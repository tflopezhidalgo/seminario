package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonaSpec extends Specification implements DomainUnitTest<Persona> {

    def setup() {
    }

    def cleanup() {
    }

    void "se crea una persona para chequear el nombre"() {
        when: "se crea una persona"
        Persona persona = new Persona('Juan', 'Lopez', 20)

        then: "chequeo el nombre"
        persona.nombre == "Juan"
    }

    void "se crea una persona para chequear su apellido"() {
        when: "se crea una persona"
        Persona persona = new Persona('Juan', 'Lopez', 20)

        then: "chequeo el apellido"
        persona.apellido == "Lopez"
    }

    void "se crea una persona para chequear la edad"() {
        when: "se crea una persona"
        Persona persona = new Persona('Juan', 'Lopez', 20)

        then: "chequeo el nombre"
        persona.edad == 20
    }
}
