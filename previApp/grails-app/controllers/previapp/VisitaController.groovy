package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.access.annotation.Secured

class VisitaController {

    VisitaService visitaService
    SpringSecurityService springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond visitaService.list(params), model:[visitaCount: visitaService.count()]
    }

    def show(Long id) {
        respond visitaService.get(id)
    }

    def create(Lugar lugar) {
        def visita = new Visita(params)
	visita.setLugar(lugar)

        respond visita
    }

    def save(Visita visita) {
        if (visita == null) {
            notFound()
            return
        }

        try {
            String user = springSecurityService.principal.username
            def currentUser = Usuario.findByUsername(user)

            visita.setUsuario(currentUser)
            visitaService.save(visita)
        } catch (ValidationException e) {
            respond visita.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'visita.label', default: 'Visita'), visita.id])
                redirect(action: 'index')
            }
            '*' { respond visita, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond visitaService.get(id)
    }

    def update(Visita visita) {
        if (visita == null) {
            notFound()
            return
        }

        try {
            visitaService.save(visita)
        } catch (ValidationException e) {
            respond visita.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'visita.label', default: 'Visita'), visita.id])
                redirect visita
            }
            '*'{ respond visita, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        visitaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'visita.label', default: 'Visita'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'visita.label', default: 'Visita'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
