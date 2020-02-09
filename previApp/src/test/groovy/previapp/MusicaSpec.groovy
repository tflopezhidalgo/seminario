package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MusicaSpec extends Specification implements DomainUnitTest<Musica> {

    def setup() {
    }

    def cleanup() {
    }

    void "Test de constructor de musica"() {
		when:"Creo un genero musical"
		Musica musica = new Musica('Rock')

        then:"fix me"
        musica.generoMusical == 'Rock'
    }
}

