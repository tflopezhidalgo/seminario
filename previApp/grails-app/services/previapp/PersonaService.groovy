package previapp

import grails.gorm.services.Service

@Service(Persona)
interface PersonaService {

    Persona get(Serializable id)

    List<Persona> list(Map args)

    Long count()

    void delete(Serializable id)

    Persona save(Persona persona)

}