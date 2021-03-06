package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Zona)
abstract class ZonaService {

    static RADIO_MAXIMO = new Kilometro(10)

	LugarService lugarService

    abstract Zona get(Serializable id)

	abstract List<Zona> list(Map args)

	abstract Long count()

	abstract void delete(Serializable id)

	abstract Zona save(Zona zona)

	List<Lugar> obtenerLugaresEnZona(Zona zona){
	    new ArrayList<Lugar>(zona.getLugares())
	}

	List<Zona> obtenerZonasCercanas(Zona zona){
	    def zonasDisponibles = Zona.findAll()
	    zonasDisponibles.findAll { zonaDisponible ->
            zona.distanciaConZona(zonaDisponible) < this.RADIO_MAXIMO
	    }
	}
}
