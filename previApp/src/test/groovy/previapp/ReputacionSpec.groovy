package previapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ReputacionSpec extends Specification implements DomainUnitTest<Reputacion> {

    def setup() {
    }

    def cleanup() {
    }

    void "se crea una Reputacion con estado inicial valido"() {
        when: "creo una Reputacion"
        Reputacion reputacion = new Reputacion()

        then: "chequeo que inicialize bien"
        reputacion.puntos == 0 && reputacion.nombreReputacion == 'Bronce'
    }

    void "se cargan puntos a una Reputacion"() {
        when: "creo una Reputacion y le actualizo puntos"
        Reputacion reputacion = new Reputacion()
        reputacion.sumarPuntos(30)

        then: "chequeo que el puntaje se cargue bien"
        reputacion.puntos == 30
    }

    void "convierto una Reputacion a Plata"() {
        when: "creo una Reputacion y la subo de nivel"
        Reputacion reputacion = new Reputacion()
        reputacion.sumarPuntos(60)

        then: "chequeo que sea de plata"
        reputacion.nombreReputacion == 'Plata'
    }

    void "convierto una Reputacion a Oro"() {
        when: "creo una Reputacion y la subo de nivel 2 veces"
        Reputacion reputacion = new Reputacion()
        reputacion.sumarPuntos(160)

        then: "chequeo que sea de oro"
        reputacion.nombreReputacion == 'Oro'
    }
}