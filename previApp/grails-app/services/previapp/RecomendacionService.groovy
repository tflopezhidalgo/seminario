package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service


class RecomendacionService {

	ZonaService zonaService

	List<Recomendacion> recomendar(Usuario usuario) {
		print("zonas del usuario ${usuario.getZona()}")
		// Transaccion principal
		List<Lugar> lugares = zonaService.obtenerLugaresEnZona(usuario.getZona())
		List<Recomendacion> recomendaciones = []
		lugares.each { lugar ->
			Recomendacion recomendacion = new Recomendacion(lugar, usuario)
			recomendacion.calcularPuntaje()
			recomendaciones << recomendacion
		}

		return recomendaciones.sort()
	}

}
