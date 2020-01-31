package previapp

import grails.gorm.services.Service

@Service(Lugar)
interface LugarService {

    Lugar get(Serializable id)

    List<Lugar> list(Map args)

    Long count()

    void delete(Serializable id)

    Lugar save(Lugar lugar)

	List<Lugar> obtenerLugaresCompatibles(Usuario usuario) {}


}
