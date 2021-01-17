package previapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ProfileController {

    SpringSecurityService springSecurityService
    UsuarioService usuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def index() {
        String user = springSecurityService.principal.username

        def currentUser = Usuario.findByUsername(user)

        print("Entrando a perfil de usuario $currentUser")

	println("id del usuario actual ${currentUser.id}")

        if (!currentUser)
	    render "No hay ningun usuario logeado!"
	else
	    render(view: 'show', model: ['entityName': 'Usuario', 'currentUser': currentUser])
    }

    def edit() {
        String user = springSecurityService.principal.username
        def currentUser = Usuario.findByUsername(user)

    	print("editando usuario $currentUser")
        render(view: 'edit', model: ['entityName': 'Usuario', 'usuario': currentUser])
    }

    def update() {
        String user = springSecurityService.principal.username
        def currentUser = Usuario.findByUsername(user)

        currentUser.properties = params

        try {
	    usuarioService.save(currentUser)
        } catch (ValidationException e) {
            respond params.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuario.label', default: 'Usuario'), currentUser.id])
                redirect action: "index", method: "GET" 
            }
            '*'{ respond currentUser, [status: OK] }
        }
	render("TODO ok ")
    }

}
