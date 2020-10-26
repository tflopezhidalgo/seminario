package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LandingController {

    RecomendacionService recomendacionService
    LugarService lugarService
    UsuarioService usuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
	def lugar = lugarService.get('Mi casa')
	def usuario = Usuario.findByUsername("tomas")

	def recomendacionList = recomendacionService.recomendar(usuario)

        recomendacionList.each { 
            recomendacion -> print(recomendacion)
        }

	render(view: '/index', model: ['recomendaciones': recomendacionList])	
    }

}
