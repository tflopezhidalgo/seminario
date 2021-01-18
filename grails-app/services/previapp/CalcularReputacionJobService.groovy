package previapp

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.beans.factory.annotation.Autowired
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

class CalcularReputacionJobService {

    static lazyInit = false

    DummyService dummyService

    /* Diario a las 00:00 horas */
    @Scheduled(cron = "0 0 0 * * *")
    void execute() {
        dummyService.recalcularReputaciones()
        println("¡Todas las puntuaciones recalculadas!")
    }
}
