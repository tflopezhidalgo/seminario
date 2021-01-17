package previapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LugarServiceSpec extends Specification {

    LugarService lugarService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Lugar(...).save(flush: true, failOnError: true)
        //new Lugar(...).save(flush: true, failOnError: true)
        //Lugar lugar = new Lugar(...).save(flush: true, failOnError: true)
        //new Lugar(...).save(flush: true, failOnError: true)
        //new Lugar(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //lugar.id
    }

    void "test get"() {
        setupData()

        expect:
        lugarService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Lugar> lugarList = lugarService.list(max: 2, offset: 2)

        then:
        lugarList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        lugarService.count() == 5
    }

    void "test delete"() {
        Long lugarId = setupData()

        expect:
        lugarService.count() == 5

        when:
        lugarService.delete(lugarId)
        sessionFactory.currentSession.flush()

        then:
        lugarService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Lugar lugar = new Lugar()
        lugarService.save(lugar)

        then:
        lugar.id != null
    }
}
