package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Service(Musica)
interface MusicaService {

    Musica get(Serializable id)
	
    List<Musica> list(Map args)

    Long count()

    void delete(Serializable id)

    Musica save(Musica musica)
}
