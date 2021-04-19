package previapp

import grails.gorm.services.Service
import grails.plugin.springsecurity.SpringSecurityService

@Service(Visita)
abstract class VisitaService {

    LugarService lugarService
    UsuarioService usuarioService

    abstract Visita get(Serializable id)

    abstract List<Visita> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Visita save(Visita visita)

    Visita crearVisitaEnLugar(Usuario usuario, Lugar lugar, Date fecha, String comentario, Puntuacion puntuacion) {
        Visita visita = new Visita( usuario, lugar, fecha, puntuacion, comentario)
        visita.setUsuario(usuario)
        visita.lugar.addToVisitas(visita)
        visita.lugar.calcularPuntuacion()
        lugarService.save(visita.lugar)

        usuario.reputacion.incrementar(20)
        usuarioService.save(usuario)
        visita
    }

    /* Ordena la lista de visitas según la importancia de los usuarios */
    List<Visita> visitasDeUsuariosOro(List <Visita> visitas) {
        List <Visita> visitasOro = visitas.findAll {
            visita -> visita.esVisitaOro()
        }
        return visitasOro.sort()
    }

    List <Visita> visitasDeUsuariosNoOro(List <Visita> visitas) {
        List <Visita> visitasNoOro = visitas.findAll {
            visita -> !visita.esVisitaOro()
        }
        return visitasNoOro.sort()
    }

    Boolean usuarioVisitoLugar(Usuario usuario, Lugar lugar) {
        def visito = (Visita.findByUsuarioAndLugar(usuario, lugar) == null) ? false : true
        return visito
    }
}
