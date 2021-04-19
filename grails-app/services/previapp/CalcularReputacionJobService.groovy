package previapp

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.beans.factory.annotation.Autowired
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

class CalcularReputacionJobService {

    static lazyInit = false

    IncrementarReputacionService incrementarReputacionService

    @Scheduled(cron = "0 0 0 * * *")
    void execute() {
        /* Diariamente incrementa las reputaciones de los usuarios
         * esto para que los usuarios vayan adquiriendo reputación
         * en base a su antiguedad
         */
        incrementarPuntuacionService.recalcularReputaciones()
        log.debug("Reputaciones recalculadas")
    }
}
