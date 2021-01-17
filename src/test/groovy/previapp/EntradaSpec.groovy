package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class EntradaSpec extends Specification implements DomainUnitTest<Entrada> {

    def setup() {
    }

    def cleanup() {
    }

    void "se crea una entrada y se chequea el precio de venta"() {
        when: "se crea una clase de entrada"
        Entrada entrada = new Entrada(30)

        then: "chequeo que la entrada valga 30"
        entrada.precio == 30
    }
}
