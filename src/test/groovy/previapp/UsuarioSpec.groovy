package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UsuarioSpec extends Specification implements DomainUnitTest<Usuario> {

    def setup() {
    }

    def cleanup() {
    }

    void "se crea un usuario para chequear el nombre"() {
        when: "se crea un usuario"
        Usuario usuario = new Usuario('Juan')

        then: "chequeo el nombre"
        usuario.nombre == "Juan"
    }

    void "se crea un usuario con persona"() {
        when: "se crea un usuario"
        Persona persona = new Persona('Juan', 'Lopez', 20)
        Usuario usuario = new Usuario('Juan', persona)

        then: "chequeo que tenga la persona"
        usuario.persona == persona
    }
}
