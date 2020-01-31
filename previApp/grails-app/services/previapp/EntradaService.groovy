package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Entrada)
abstract EntradaService {
	
	Entrada get(Serializable id)

	List<Entrada> list(Map args)

	Long count()

	void delete(Serializable id)

	Entrada save(Entrada entrada)	

	/* Tenemos que ver el tema de las entradas en general
	 * porque no manejamos dinero en sí, por lo que no se podrían
	 * comprar si no solo "reservar" (sin poner un solo centavo) 
	 * y que después se paguen en puerta o algo así
	 */ 
	def reservarEntrada(Usuario usuario, Lugar lugar) {}

}
