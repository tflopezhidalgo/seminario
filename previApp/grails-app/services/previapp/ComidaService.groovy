package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Comida)
interface ComidaService {

	Comida get(Serializable id)

	List<Comida> list(Map args)

	Long count()

	void delete(Serializable id)

	Comida save(Comida comida)

}
