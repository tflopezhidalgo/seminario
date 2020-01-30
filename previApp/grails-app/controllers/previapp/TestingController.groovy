package previapp

class TestingController {

	LugarService lugarService
	UsuarioService usuarioService
	PersonaService personaService

    def index() { 
		Lugar unLugar = new Lugar('Mi casita', 'Mariano Moreno 3939', 20)		
		Persona persona = new Persona('Tomas', 'Lopez', 23)
		Usuario usuario = new Usuario('tofelohi', persona)

		lugarService.save(unLugar)
		usuarioService.save(usuario)

		render 'Se creo lugar $unLugar, $usuario, $persona'
	}

	def addOne() {
		Lugar lugar = lugarService.get('Mi casita')
		Usuario usuario = usuarioService.get('tofelohi')
		Visita visita = new Visita('Una visita')
		lugar.addToVisitas(visita)
		usuario.addToVisitas(visita)
		lugarService.save(lugar)		
		usuarioService.save(usuario)
	}

	def deleteUser() {
		lugarService.delete('Mi casita')	

	}

	def addOneEntry() {
		Entrada entrada = new Entrada(30)
		Lugar lugar = lugarService.get('Mi casita')
		lugar.addToEntradas(entrada)
		lugarService.save(lugar)
	}

	def sellOneEntry() {
	

	}

}
