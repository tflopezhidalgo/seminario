package previapp

import grails.gorm.services.Service

@Service(Visita)
abstract class VisitaService {

    abstract Visita get(Serializable id)

    abstract List<Visita> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Visita save(Visita visita)

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
