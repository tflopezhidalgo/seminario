package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BebidaSpec extends Specification implements DomainUnitTest<Bebida> {

    def setup() {
    }

    def cleanup() {
    }

    void "se crea una bebida y se chequea su nombre"() {
        when: "se crea una clase de bebida"
        Bebida bebida = new Bebida('Pepsi', 20)

        then: "chequeo que la bebida sea papa"
        bebida.nombre == "Pepsi"
    }

    void "se crea una bebida y se chequea el precio de venta"() {
        when: "se crea una clase de bebida"
        Bebida bebida = new Bebida('Coca', 30)

        then: "chequeo que la bebida valga 30"
        bebida.costo == 30
    }
}
