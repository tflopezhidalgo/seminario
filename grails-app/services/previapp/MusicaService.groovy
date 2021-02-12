package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Musica)
abstract class MusicaService {

    abstract Musica get(Serializable id)

    abstract List<Musica> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Musica save(Musica musica)

    List<Musica> obtenerMusica(List<Serializable> ids) {
        ids.collect { id -> this.get(id) }
    }
}
