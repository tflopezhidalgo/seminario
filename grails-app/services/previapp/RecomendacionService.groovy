package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service


class RecomendacionService {

	ZonaService zonaService

	List<Recomendacion> recomendar(Usuario usuario) {
		// Transaccion principal
		List<Lugar> lugares = zonaService.obtenerLugaresEnZona(usuario.getZona())

		/* FIXME: verificar que se cumpla también el caso en que el usuario visitó 
			  todos los lugares de su zona */
		if (!lugares.size()) {
		    println("No se encontraron lugares en la zona ${usuario.getZona()}")
		    def zonasCercanas = zonaService.obtenerZonasCercanas(usuario.getZona())
		    println("Buscando en ${zonasCercanas[0]}")
		    lugares = zonaService.obtenerLugaresEnZona(zonasCercanas[0])
		}

		lugares = lugares.findAll({ lugar ->
			(lugar.obtenerPrecioBase() <= usuario.presupuesto.monto)
		})

		List<Recomendacion> recomendaciones = lugares.collect { lugar ->
			return new Recomendacion(lugar, usuario) 
		}

		recomendaciones.sort().reverse()
	}
}
