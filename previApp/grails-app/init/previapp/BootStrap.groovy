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

        Lugar lugar = new Lugar('Mi casa', 'QueTeImporta 123', 300)
        lugar.addToComidas(comida)
        lugar.addToBebidas(bebida)
        lugar.addToMusica(musica)
        lugar.setZona(zona)

        lugarService.save(lugar)

        // security reoles iniciales


        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true) 
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)

        def adminUser = Usuario.findByUsername("admin") ?: new Usuario("admin", "admin", persona, zona, musica, pr).save(failOnError: true)
        def newUser = Usuario.findByUsername("tomas") ?: new Usuario("tomas", "tomas", persona, zona, musica, pr).save(failOnError: true)

        // TODO: ESTO NO ESTÁ FUNCIONANDO
        def userrole1 = UsuarioRole.create(adminUser, adminRole, true)
        print("Guardado user role ${userrole1}")

        def userrole2 = UsuarioRole.create(newUser, userRole, true)
        print("Guardado user role ${userrole2}")

        print("Bootstrap inicializado!\n")
    }

    def destroy = {

    }
}
