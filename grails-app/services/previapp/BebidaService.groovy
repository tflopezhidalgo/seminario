package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Bebida)
abstract class BebidaService {

    abstract Bebida get(Serializable id)

    abstract List<Bebida> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Bebida save(Bebida bebida)

    List<Bebida> obtenerBebidas(List<Serializable> ids) {
        ids.collect { id -> this.get(id) }
    }
}
