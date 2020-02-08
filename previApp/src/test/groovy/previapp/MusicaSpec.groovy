package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MusicaSpec extends Specification implements DomainUnitTest<Musica> {

    def cleanup() {}

    void "se crea una clase de musica de un genero"() {
        when "se crea una clase de musica de genero Jazz"
            Musica musica = new Musica('Jazz')

        then "chequeo el genero de musica"
            musica.generoMusical == "Jazz"
    }

    //def setup() {}

}
