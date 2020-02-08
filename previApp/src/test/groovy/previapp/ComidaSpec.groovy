package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ComidaSpec extends Specification implements DomainUnitTest<Comida> {

    def cleanup() {}

    void "se crea una comida y se chequea su nombre"() {
        when "se crea una clase de comida"
            Comida comida = new Comida('papa', 20)

        then "chequeo que la comida sea papa"
            comida.nombre == "papa"
    }

    void "se crea una comida y se chequea el precio de venta"() {
        when "se crea una clase de comida"
            Comida comida = new Comida('papa', 30)

        then "chequeo que la comida valga 30"
            comida.precio == 30
    }
}
