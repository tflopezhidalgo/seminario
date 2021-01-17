package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.SpringSecurityService

class LandingController {

    RecomendacionService recomendacionService
    UsuarioService usuarioService
    SpringSecurityService springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        String currentUsername = springSecurityService.principal.username

        def currentUser = Usuario.findByUsername(currentUsername)

	if (!currentUser) {
	    redirect(controller: "login")
	} else {
	    println("Buscando recomendaciones para ${currentUsername}")

	    def recomendaciones = recomendacionService.recomendar(currentUser)
	    render(view: '/index', model: ['recomendaciones': recomendaciones])	
	}
    }
}
