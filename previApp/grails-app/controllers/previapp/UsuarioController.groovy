package previapp

class UsuarioController {

    def index() { 
		def reputacion = new Reputacion()
		def persona = new Persona('Tomas', 'Lopez', 23)
		def usuario = new Usuario(reputacion, persona)
		usuario.agregarVisita('Mi casa')
		usuario.save()

		render "Entraste a UsuarioController"
	}

    def create() {}

    def show() {}

    def edit() {}
}
