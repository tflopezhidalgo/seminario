package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ComidaController {

    ComidaService comidaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond comidaService.list(params), model:[comidaCount: comidaService.count()]
    }

    def show(Long id) {
        respond comidaService.get(id)
    }

    def create() {
        respond new Comida(params)
    }

    def save(Comida comida) {
        if (comida == null) {
            notFound()
            return
        }

        try {
            comidaService.save(comida)
        } catch (ValidationException e) {
            respond comida.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'comida.label', default: 'Comida'), comida.id])
                redirect(action: 'index')
            }
            '*' { respond comida, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond comidaService.get(id)
    }

    def update(Comida comida) {
        if (comida == null) {
            notFound()
            return
        }

        try {
            comidaService.save(comida)
        } catch (ValidationException e) {
            respond comida.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'comida.label', default: 'Comida'), comida.id])
                redirect comida
            }
            '*'{ respond comida, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        comidaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'comida.label', default: 'Comida'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comida.label', default: 'Comida'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
