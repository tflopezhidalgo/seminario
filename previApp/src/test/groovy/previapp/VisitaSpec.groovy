package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class VisitaSpec extends Specification implements DomainUnitTest<Visita> {

    def setup() {
    }

    def cleanup() {
    }

    void "Test de constructor de visita"() {
		when:"Creo una visita"
		Visita visita = new Visita("lindo lugar")

        then:"veo que se cree bien"
        visita.comentario_visita == "lindo lugar"
    }

    void "Test de cambiar comentario"() {
		when:"Creo una visita y le cambio su comentario"
		Visita visita = new Visita("lindo lugar")
        visita.setComentario("era barato")

        then:"veo que se cambiara el comentario"
        visita.comentario_visita == "era barato"
    }
    //todo hacer test de la fecha de creacion
}
