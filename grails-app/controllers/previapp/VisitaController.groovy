package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.access.annotation.Secured


class VisitaForm {
    Long lugarId
    Date fecha
    String comentario
    Integer puntuacion

    static constraints = {
        lugarId nullable: false
        fecha nullable: false
        comentario nullable: true
        puntuacion nullable: false, min: 0
    }
}


class VisitaController {

    VisitaService visitaService
    LugarService lugarService
    UsuarioService usuarioService
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
        def visitaForm = new VisitaForm()
        visitaForm.setLugarId(lugar.id)

        respond visitaForm, model: [nombreLugar: lugar.getNombre(), errorMsg: params.errorMsg]
    }

    def save(VisitaForm visitaForm) {
        try {
            String user = springSecurityService.principal.username
            def currentUser = Usuario.findByUsername(user)

            Lugar lugar = lugarService.get(visitaForm.lugarId)

            def visita = visitaService.crearVisitaEnLugar(currentUser, lugar, visitaForm.fecha, visitaForm.comentario, new Puntuacion(visitaForm.puntuacion))
            visitaService.save(visita)

            log.debug("Guardada visita de ${currentUser} para lugar ${lugar}")

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'visita.label', default: 'Visita'), visita.id])
                    redirect(action: 'index')
                }
                '*' { respond visita, [status: CREATED] }
            }

        } catch (ValidationException e) {
            redirect(action: 'create', params: [errorMsg: e.getMessage(), id: visitaForm.lugarId])
        } catch(CapacidadMaximaInvalidaError e) {
            def msg = "${e.capacidadInvalida} no es un valor válido para la capacidad"
            redirect(action: 'create', params: [errorMsg: msg, id: visitaForm.lugarId])
        } catch(DineroConMontoInvalidoError e) {
            def msg = "${e.montoErroneo} no es un monto de entrada válido"
            redirect(action: 'create', params: [errorMsg: msg, id: visitaForm.lugarId])
        } catch(DireccionInvalidaError e) {
            def msg = "La dirección ${e.direccionInvalida} no es una dirección válida"
            redirect(action: 'create', params: [errorMsg: msg, id: visitaForm.lugarId])
        } catch(PuntuacionInvalidaError e) {
            def msg = "${e.puntuacionInvalida} no es un valor válido para la puntuación"
            redirect(action: 'create', params: [errorMsg: msg, id: visitaForm.lugarId])
        } catch (RuntimeException e) {
            redirect(action: 'create', params: [errorMsg: e.getMessage(), id: visitaForm.lugarId])
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
