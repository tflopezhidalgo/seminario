package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class LugarSpec extends Specification implements DomainUnitTest<Lugar> {

    def setup() {
    }

    def cleanup() {

    }

    void "se crea un lugar para chequear el barrio"() {
        when: "se crea un lugar en Palermo"
        Lugar lugar = new Lugar('Palermo', 'nvm', 200)

        then: "chequeo el lugar"
        lugar.nombre == "Palermo"
    }

    void "se crea un lugar para chequear la direccion"() {
        when: "se crea un lugar con direccion en Larralde"
        Lugar lugar = new Lugar('Palermo', 'Larralde 2500', 200)

        then: "chequeo la direccion"
        lugar.direccion == "Larralde 2500"
    }

    void "se crea un lugar con capacidad de 125 personas"() {
        when: "se crea un lugar con dicha capacidad"
        Lugar lugar = new Lugar('Palermo', 'nvm', 125)

        then: "chequeo la capacidad"
        lugar.capacidadMaxima == 125
    }

    void "se crea un lugar con entrada"() {
        when: "se crea un lugar"
        Entrada entradita = new Entrada(20)
        Lugar lugar = new Lugar('Palermo', 'nvm', 125, entradita)

        then: "chequeo la entrada"
        lugar.entrada == entradita
    }

}
