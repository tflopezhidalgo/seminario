package previapp

class BootStrap {

	MusicaService musicaService
	ComidaService comidaService
	BebidaService bebidaService

    def init = { servletContext ->

		Musica musica = new Musica('Rock')
		musicaService.save(musica)

		Comida comida = new Comida('Sushi', 25)
		comidaService.save(comida)

		Bebida bebida = new Bebida('Coca-cola', 250)
		bebidaService.save(bebida)
    }
    
	def destroy = {}
}
