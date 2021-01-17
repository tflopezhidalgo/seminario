package previapp
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class TestingController {

	LugarService lugarService
	UsuarioService usuarioService
	ZonaService zonaService
	MusicaService musicaService
	RecomendacionService recomendacionService
	SpringSecurityService springSecurityService

    def index() { 

    	String user = springSecurityService.principal.username

	def lugar = lugarService.get('Mi casa')
	def usuario = usuarioService.get('tomas')

	def recomendacionList = recomendacionService.recomendar(usuario)

	render "Se obtuvo como recomendacion $recomendacionList para el usuario actual $usuario"	
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
