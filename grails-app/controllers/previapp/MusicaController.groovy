package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MusicaController {

    MusicaService musicaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond musicaService.list(params), model:[musicaCount: musicaService.count()]
    }

    def show(Long id) {
        respond musicaService.get(id)
    }

    def create() {
        respond new Musica(params)
    }

    def save(Musica musica) {
        if (musica == null) {
            notFound()
            return
        }

        try {
            musicaService.save(musica)
        } catch (ValidationException e) {
            respond musica.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.created.message', args: [message(code: 'musica.label', default: 'Musica'), musica.id])
                redirect(action: 'index')
            }
            '*' { respond musica, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond musicaService.get(id)
    }

    def update(Musica musica) {
        if (musica == null) {
            notFound()
            return
        }

        try {
            musicaService.save(musica)
        } catch (ValidationException e) {
            respond musica.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'musica.label', default: 'Musica'), musica.id])
                redirect musica
            }
            '*'{ respond musica, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        musicaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'musica.label', default: 'Musica'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musica.label', default: 'Musica'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
