package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PresupuestoSpec extends Specification implements DomainUnitTest<Presupuesto> {

    def setup() {
    }

    def cleanup() {
    }

    void "Test de constructor de presupuesto"() {
		when:"Creo un presupuesto"
		Presupuesto presupuesto = new Presupuesto(15)

        then:"veo que se creo bien"
        presupuesto.montoPresupuesto == 15
    }

    void "Test de exceder presupuesto"() {
		when:"Creo un genero presupuesto"
		Presupuesto presupuesto = new Presupuesto(50)

        then:"veo que me este excediendo del presupuesto"
        presupuesto.excediPresupuesto(100) == true
    }

    void "Test de NO exceder presupuesto"() {
		when:"Creo un genero presupuesto"
		Presupuesto presupuesto = new Presupuesto(50)

        then:"veo que NO me este excediendo del presupuesto"
        presupuesto.excediPresupuesto(10) == false
    }

    //ToDo: testear el Lugar excede presupuesto cuando este implementado
}
