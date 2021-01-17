package previapp

import grails.gorm.services.Service

@Service(Visita)
interface VisitaService {

    Visita get(Serializable id)

    List<Visita> list(Map args)

    Long count()

    void delete(Serializable id)

    Visita save(Visita visita)

}