package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LugarController {

    LugarService lugarService
    VisitaService visitaService
    MusicaService musicaService
    ComidaService comidaService
    BebidaService bebidaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond lugarService.list(params), model:[lugarCount: lugarService.count()]
    }

    def show(Long id) {
        // El lugar solo se puede editar por el admin, no incluímos botones de edit / delete
        Lugar lugar = lugarService.get(id)
        List<Visita> visitas = []
        visitas.addAll(lugar.visitas)
        List<Visita> visitasOro = visitaService.visitasDeUsuariosOro(visitas)
        List<Visita> visitasNoOro = visitaService.visitasDeUsuariosNoOro(visitas)

        respond lugar, model:[visitasOro: visitasOro, visitasNoOro: visitasNoOro], view: 'guestView'
    }

    def create() {
        respond new Lugar(params)
    }

    def crearLugar(Lugar lugar, Musica musica, Comida comida, Bebida bebida) {
        this.save(lugar)
        musicaService.save(musica)
        comidaService.save(comida)
        bebidaService.save(comida)
    }

    def save(Lugar lugar) {
        if (lugar == null) {
            notFound()
            return
        }

        try {
            lugarService.save(lugar)
        } catch (ValidationException e) {
            respond lugar.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lugar.label', default: 'Lugar'), lugar.id])
                redirect(action: 'index')
            }
            '*' { respond lugar, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond lugarService.get(id)
    }

    def update(Lugar lugar) {
        if (lugar == null) {
            notFound()
            return
        }

        try {
            lugarService.save(lugar)
        } catch (ValidationException e) {
            respond lugar.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lugar.label', default: 'Lugar'), lugar.id])
                redirect lugar
            }
            '*'{ respond lugar, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        lugarService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lugar.label', default: 'Lugar'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lugar.label', default: 'Lugar'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
