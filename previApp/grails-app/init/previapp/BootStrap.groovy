package previapp

class BootStrap {
    MusicaService musicaService
    ComidaService comidaService
    BebidaService bebidaService
    ZonaService zonaService
    UsuarioService usuarioService
    LugarService lugarService

    def init = { servletContext ->
        def musica = new Musica('Rock').save(flush: true, failOnError: true)
        def comida = new Comida('Sushi', 25).save(flush: true, failOnError: true)
        def bebida = new Bebida('Coca-cola', 250).save(flush: true, failOnError: true)
        def zona = new Zona('Avellaneda').save(flush: true, failOnError: true)

        def persona = new Persona('Tomas', 'Lopez', 23)
        def pr = new Presupuesto(2300)
		
        def entrada = new Entrada(200)

        def lugar = new Lugar('Mi casa', 'QueTeImporta 123', 300)
        lugar.addToComidas(comida)
        lugar.addToBebidas(bebida)
        lugar.addToMusica(musica)
        lugar.setZona(zona)
        lugar.setEntrada(entrada)

        lugar.save(failOnError: true)

        // security reoles iniciales

        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true) 
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)

        def adminUser = Usuario.findByUsername("admin") ?: new Usuario("admin", "admin", persona, zona, musica, pr).save(failOnError: true)
        def newUser = Usuario.findByUsername("tomas") ?: new Usuario("tomas", "tomas", persona, zona, musica, pr).save(failOnError: true)

        def userrole1 = UsuarioRole.create(adminUser, adminRole, true)
        print("Guardado user role ${userrole1}")

        def userrole2 = UsuarioRole.create(newUser, userRole, true)
        print("Guardado user role ${userrole2}")

        print("\n-- Bootstrap inicializado! --\n")
    }

    def destroy = {

    }
}
