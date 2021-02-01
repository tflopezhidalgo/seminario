package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service


class RecomendacionService {
    Integer RECOMENDATION_LIMIT = 5

    ZonaService zonaService
    VisitaService visitaService

    List<Recomendacion> recomendar(Usuario usuario) {
        // Transaccion principal
        List<Lugar> lugares = zonaService.obtenerLugaresEnZona(usuario.getZona())

        /* Nos quedamos con los que no visitamos */
        lugares = lugares.findAll { lugar ->
            !visitaService.usuarioVisitoLugar(usuario, lugar)
        }

        /* TODO: caso en que el usuario visitó todos los lugares de ambas zonas */
       if (!lugares.size()) {
            println("No se encontraron lugares en la zona ${usuario.getZona()}")
            def zonasCercanas = zonaService.obtenerZonasCercanas(usuario.getZona())
            println("Buscando en ${zonasCercanas[0]}")
            lugares = zonaService.obtenerLugaresEnZona(zonasCercanas[0])
        }

        /* Nos quedamos con los que nos alcanza el presupuesto */
        lugares = lugares.findAll({ lugar ->
            (lugar.obtenerPrecioBase() <= usuario.presupuesto.monto)
        })

        List<Recomendacion> recomendaciones = lugares.collect { lugar ->
            return new Recomendacion(lugar, usuario) 
        }

        recomendaciones.subList(0, [RECOMENDATION_LIMIT, recomendaciones.size()].min()).sort().reverse()
    }
}
