package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Comida)
abstract class ComidaService {

    abstract Comida get(Serializable id)

    abstract List<Comida> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Comida save(Comida comida)

    List<Comida> obtenerComidas(List<Serializable> ids) {
        ids.collect { id -> this.get(id) }
    }
}
