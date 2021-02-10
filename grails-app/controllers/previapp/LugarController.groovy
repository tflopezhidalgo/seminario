package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LugarController {

    LugarService lugarService
    VisitaService visitaService
    MusicaService musicaService
    ComidaService comidaService
    BebidaService bebidaService
    ZonaService zonaService

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
        def comidaDisponible = comidaService.list() 
        def bebidaDisponible = bebidaService.list()
        def musicaDisponible = musicaService.list()
        def zonasDisponibles = zonaService.list()
        respond new Lugar(), model: [zonasDisponibles: zonasDisponibles, musicaDisponible: musicaDisponible, comidaDisponible: comidaDisponible, bebidaDisponible: bebidaDisponible]                               
    }                                                     
                                                          
    def save() {
        try {
            Lugar lugar = lugarService.crearLugar([
                nombre: params.nombre,
                direccion: params.direccion,
                descripcion: params.descripcion,
                capacidadMaxima: params.capacidadMaxima,
                montoEntrada: params.monto,
                monedaEntrada: params.moneda,
                zonaId: params.zonaId,
                musicasId: params.musicasId,
                bebidasId: params.bebidasId,
                comidasId: params.comidasId,
            ])

            lugarService.save(lugar)

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'lugar.label', default: 'Lugar'), lugar.id])
                    redirect(action: 'index')
                }
                '*' { respond lugar, [status: CREATED] }
            }

        } catch (ValidationException e) {
            log.error("ValidationException: ${e}")
            respond new Lugar(), view:'create', model: [error: e]
            return
        } catch (RuntimeException e) {
            log.error("RuntimeException: ${e}")
            respond new Lugar(), view:'create', model: [error: e]
            return
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
