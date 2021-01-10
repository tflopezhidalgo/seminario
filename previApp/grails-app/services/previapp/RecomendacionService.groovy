package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service


class RecomendacionService {

	ZonaService zonaService

	List<Recomendacion> recomendar(Usuario usuario) {
		// Transaccion principal
		List<Lugar> lugares = zonaService.obtenerLugaresEnZona(usuario.getZona())
		List<Recomendacion> recomendaciones = []
		lugares.each {lugar -> 
			recomendaciones << new Recomendacion(lugar, usuario);
		}

		return recomendaciones.sort()
	}

}
