package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PuntuacionSpec extends Specification implements DomainUnitTest<Puntuacion> {

    def setup() {
    }

    def cleanup() {
    }

    void "se crea una Puntuacion"() {
        when: "creo una Puntuacion"
        Puntuacion puntuacion = new Puntuacion(2)

        then: "chequeo la cantidad de estrellas"
        puntuacion.puntajeDelUsuario == 2
    }
}
