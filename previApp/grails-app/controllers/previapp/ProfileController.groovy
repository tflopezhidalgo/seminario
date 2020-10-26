package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.SpringSecurityService

class ProfileController {

	SpringSecurityService springSecurityService
	UsuarioService usuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
	String user = springSecurityService.principal.username

	def currentUser = Usuario.findByUsername(user)

	print("Entrando a perfil de usuario $currentUser")

	render(view: 'show', model: ['entityName': 'Usuario', 'currentUser': currentUser])
    }

    def edit(user) {
    	print("editando usuario $user")

	render(view: 'edit', model: ['entityName': 'Usuario', 'currentUser': user])
    }

}
