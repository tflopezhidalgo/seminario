package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MusicaSpec extends Specification implements DomainUnitTest<Musica> {

    def setup() {
    }

    def cleanup() {
    }

    void "Esto es un test de test"() {
		when:"Creo un genero musical"
		Musica musica = new Musica('Rock')

        then:"fix me"
        musica.generoMusical == 'Rock'
    }
}
