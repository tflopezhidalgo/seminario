package previapp

class TestingController {

	LugarService lugarService
	UsuarioService usuarioService
	ZonaService zonaService
	MusicaService musicaService
	RecomendacionService recomendacionService

    def index() { 

		Musica musica = musicaService.get('Rock')		
		Zona zona = new Zona('Avellaneda')
		Lugar unLugar = new Lugar('Mi casita', 'Mariano Moreno 3939', 20)

		unLugar.setZona(zona)
		unLugar.addToMusica(musica)

		zona.addToLugares(unLugar)

		Persona persona = new Persona('Tomas', 'Lopez', 23)
		Usuario usuario = new Usuario('tofelohi', persona)
		
		zonaService.save(zona)
		lugarService.save(unLugar)
		usuarioService.save(usuario)

		render "Se creo lugar $unLugar, $usuario, $persona"
	}

	def addOneVisit() {
		Lugar lugar = lugarService.get('Mi casita')
		Usuario usuario = usuarioService.get('tofelohi')
		Visita visita = new Visita('Una visita')

		lugar.addToVisitas(visita)
		usuario.addToVisitas(visita)

		lugarService.save(lugar)		
		usuarioService.save(usuario)
	}

	def deleteLugar() {
		lugarService.delete('Mi casita')	
	}

	def addLugarToZona() {
		Lugar lugar = new Lugar('La fiesta', 'JuanJose 123', 23)
		Zona zona = zonaService.get('Avellaneda')

		lugar.setZona(zona)
		lugarService.save(lugar)
		zona.agregarLugar(lugar)
		
		zonaService.save(zona)
		
		render 'Listorti'
	}

}
