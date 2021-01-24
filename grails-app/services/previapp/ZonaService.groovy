package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Zona)
abstract class ZonaService {

	LugarService lugarService

    	abstract Zona get(Serializable id) 
	
	abstract List<Zona> list(Map args)

	abstract Long count()

	abstract void delete(Serializable id)

	abstract Zona save(Zona zona)

	List<Lugar> obtenerLugaresEnZona(Zona zona){
	    return new ArrayList<Lugar>(zona.getLugares())
	}

	List<Zona> obtenerZonasCercanas(Zona zona){
	    def zonasDisponibles = Zona.findAll()
	    return zonasDisponibles.findAll { zonaDisponible -> 
		zona.distanciaConZona(zonaDisponible) > 10
	    }
	}
}
