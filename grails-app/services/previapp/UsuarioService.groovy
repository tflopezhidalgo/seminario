package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

class DummyService {

    @Transactional
    void recalcularReputaciones() {
        Usuario.findAll().each {usuario -> 
            usuario.reputacion.incrementar(10)
            usuario.markDirty()
            usuario.save(flush: true, failOnError: true)
            println("Puntuación de usuario ${usuario} recalculada")
        }
    }    
}

@Service(Usuario)
@CompileStatic
abstract class UsuarioService {

    abstract Usuario get(Serializable id)

    abstract List<Usuario> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Usuario save(Usuario usuario)
}
