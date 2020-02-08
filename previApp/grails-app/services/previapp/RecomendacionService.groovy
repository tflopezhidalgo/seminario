package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service


class RecomendacionService {

	ZonaService zonaService

	List<Recomendacion> recomendar(Usuario usuario) {
		// Transaccion principal
		List<Lugar> lugares = zonaService.obtenerLugaresEnZona(usuario.zona)
		List<Recomendacion> recomendaciones = []
		lugares.each { lugar ->
			recomendacion = new Recomendacion(lugar, usuario)
			recomendacion.calcularPuntaje()
			recomendaciones.append(recomendacion)
		}

		return recomendaciones
	}

}
