package previapp

class TestingController {

	LugarService lugarService
	UsuarioService usuarioService
	ZonaService zonaService
	MusicaService musicaService
	RecomendacionService recomendacionService

    def index() { 
		
		def lugar = lugarService.get('Mi casa')
		def usuario = usuarioService.get('tomas131')

		def recomendacionList = recomendacionService.recomendar(usuario)

		render "Se obtuvo como recomendacion $recomendacionList"
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
