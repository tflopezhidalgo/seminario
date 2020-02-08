package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonaSpec extends Specification implements DomainUnitTest<Persona> {

    def setup() {
    }

    def cleanup() {
    }

    void "Se crea una Persona con nombre y apellido"() {
		when: "Se crea presona con nombre: Tomas"
			Persona persona = new Persona('Tomas', 'Testing', 23)
	
        then:"Nombre de la persona sea Tomas"
            persona.nombre == 'Tomas'
    }
}
