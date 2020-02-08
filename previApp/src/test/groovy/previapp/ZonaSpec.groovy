package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ZonaSpec extends Specification implements DomainUnitTest<Zona> {

    def cleanup() {}

    void "se crea una zona y se chequea su nombre"() {
        when "se crea una clase de zona"
            Zona zona = new Zona('palermo')

        then "chequeo que la zona sea palermo"
            zona.nombre == "palermo"
    }

    //ToDo agregar test sobre los lugares de la zona
}
