package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


class LugarForm {
    String nombre
    String direccion
    String descripcion
    Integer capacidadMaxima
    Moneda monedaEntrada
    BigDecimal valorEntrada 
    Long zonaId 

    List<Long> musicasId
    List<Long> bebidasId
    List<Long> comidasId

    static constraints = {
        nombre nullable: false
        direccion nullable: false
        descripcion nullable: true
        capacidadMaxima nullable: false
        monedaEntrada nullable: false
        valorEntrada nullable: false
        zonaId nullable: false
        musicasId nullable: true
        bebidasId nullable: true
        comidasId nullable: true
    }

}


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

        respond lugar, model: [visitasOro: visitasOro, visitasNoOro: visitasNoOro], view: 'guestView'
    }                                                     
                                                          
    def create() {                                        
        render(view: 'create', model: [
            errorMsg: params.errorMsg,
            lugarForm: new LugarForm(),
            zonas: zonaService.list(), 
            generosMusicales: musicaService.list(), 
            comidas: comidaService.list(), 
            bebidas: bebidaService.list()
        ])
    }                                                    

    def save(LugarForm lugarForm) {
        if (lugarForm.hasErrors()){
            render(view: 'create', model: [
                errorMsg: '',
                lugarForm: lugarForm,
                zonas: zonaService.list(), 
                generosMusicales: musicaService.list(), 
                comidas: comidaService.list(), 
                bebidas: bebidaService.list()
            ])                          
            return                      
        }                               
                                                          
        try {                                             
            Lugar lugar = lugarService.crearLugar([       
                nombre: lugarForm.nombre,                 
                direccion: lugarForm.direccion,           
                descripcion: lugarForm.descripcion,       
                capacidadMaxima: lugarForm.capacidadMaxima,
                montoEntrada: lugarForm.valorEntrada,
                monedaEntrada: lugarForm.monedaEntrada,   
                zonaId: lugarForm.zonaId,                 
                musicasId: lugarForm.musicasId,           
                bebidasId: lugarForm.bebidasId,           
                comidasId: lugarForm.comidasId,           
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
            redirect(action: 'create', params: [errorMsg: e.getMessage()])
        } catch(CapacidadMaximaInvalidaError e) {
            def msg = "${e.capacidadInvalida} no es un valor válido para la capacidad"
            redirect(action: 'create', params: [errorMsg: msg])
        } catch(DineroConMontoInvalidoError e) {
            def msg = "${e.montoErroneo} no es un monto de entrada válido"
            redirect(action: 'create', params: [errorMsg: msg])
        } catch(DireccionInvalidaError e) {
            def msg = "La dirección ${e.direccionInvalida} no es una dirección válida"
            redirect(action: 'create', params: [errorMsg: msg])
        } catch (RuntimeException e) {
            redirect(action: 'create', params: [errorMsg: e.getMessage()])
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
