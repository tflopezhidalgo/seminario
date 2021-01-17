package previapp

import grails.gorm.services.Service

@Service(Lugar)
abstract class LugarService {

    abstract Lugar get(Serializable id)

    abstract List<Lugar> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Lugar save(Lugar lugar)

}
