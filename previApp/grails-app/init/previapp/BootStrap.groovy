package previapp

class BootStrap {
    MusicaService musicaService
    ComidaService comidaService
    BebidaService bebidaService
    ZonaService zonaService
    UsuarioService usuarioService
    LugarService lugarService

    def init = { servletContext ->
        Musica musica = new Musica('Rock')
        musicaService.save(musica)

        Comida comida = new Comida('Sushi', 25)
        comidaService.save(comida)

        Bebida bebida = new Bebida('Coca-cola', 250)
        bebidaService.save(bebida)

        Zona zona = new Zona('Avellaneda')
        zonaService.save(zona)

        Persona persona = new Persona('Tomas', 'Lopez', 23)
		
        Presupuesto pr = new Presupuesto(100)
        Usuario usuario = new Usuario('tomas131', persona, zona, musica, pr)
        usuarioService.save(usuario)

        Lugar lugar = new Lugar('Mi casa', 'QueTeImporta 123', 300)
        lugar.addToComidas(comida)
        lugar.addToBebidas(bebida)
        lugar.addToMusica(musica)
        lugar.setZona(zona)

        lugarService.save(lugar)
    }

    def destroy = {

    }
}
