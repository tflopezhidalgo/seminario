package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Bebida)
interface BebidaService {

	Bebida get(Serializable id)

	List<Bebida> list(Map args)

	Long count()

	void delete(Serializable id)

	Bebida save(Bebida bebida)

}
