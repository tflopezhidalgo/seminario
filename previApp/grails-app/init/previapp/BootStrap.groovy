package previapp

class BootStrap {
    MusicaService musicaService
    ComidaService comidaService
    BebidaService bebidaService
    ZonaService zonaService
    UsuarioService usuarioService
    LugarService lugarService

    def init = { servletContext ->

        /* Música disponible */
        def musicaRock = new Musica('Rock').save(flush: true, failOnError: true)
        def musicaPop = new Musica('Pop').save(flush: true, failOnError: true)
        def musicaCumbia = new Musica('Cumbia').save(flush: true, failOnError: true)

        /* Comida y bebida disponible */
        def comidaSushi = new Comida('Sushi', new Dinero(25, Moneda.ARG)).save(flush: true, failOnError: true)
        def comidaHamburguesa = new Comida('Hamburguesas', new Dinero(30, Moneda.ARG)).save(flush: true, failOnError: true)

        def bebidaCoca = new Bebida('Coca-cola', new Dinero(250, Moneda.ARG)).save(flush: true, failOnError: true)

        /* Zonas disponibles */
        def zonaAvellaneda = new Zona('Avellaneda').save(flush: true, failOnError: true)
        def zonaQuilmes = new Zona('Quilmes').save(flush: true, failOnError: true)
        def zonaCapital = new Zona('Capital Federal').save(flush: true, failOnError: true)
	
        def entrada = new Entrada(new Dinero(300, Moneda.ARG))

        /* Lugares disponibles */
        Lugar lugar = new Lugar('Restaurant "El molino"', 'Calle 123', 300)
        lugar.addToComidas(comidaSushi)
        lugar.addToBebidas(bebidaCoca)
        lugar.addToMusica(musicaRock)
        lugar.setZona(zonaAvellaneda)
        lugar.setEntrada(entrada)
        lugar.save(failOnError: true)

        Lugar lugar2 = new Lugar('Bar "El bar de Moe"', 'Washington 342', 300)
        lugar2.addToComidas(comidaHamburguesa)
        lugar2.addToBebidas(bebidaCoca)
        lugar2.addToMusica(musicaCumbia)
        lugar2.setZona(zonaCapital)
        lugar2.setEntrada(entrada)
        lugar2.save(failOnError: true)

        Lugar lugar3 = new Lugar('Tenedor libre "La vaca"', 'Olivos 5121', 300)
        lugar3.addToComidas(comidaHamburguesa)
        lugar3.addToBebidas(bebidaCoca)
        lugar3.addToMusica(musicaPop)
        lugar3.setZona(zonaCapital)
        lugar3.setEntrada(entrada)
        lugar3.save(failOnError: true)

        def persona = new Persona('Tomas', 'Lopez', 23)
        def pr = new Presupuesto(new Dinero(2300, Moneda.ARG))
	
        /* Usuarios - roles disponibles */
        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true) 
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)

        def adminUser = Usuario.findByUsername("admin") ?: new Usuario("admin", "admin", persona, zonaCapital, musicaRock, pr).save(failOnError: true)
        def newUser = Usuario.findByUsername("tomas") ?: new Usuario("tomas", "tomas", persona, zonaCapital, musicaRock, pr).save(failOnError: true)

        def userrole1 = UsuarioRole.create(adminUser, adminRole, true)
        print("Guardado user role ${userrole1}")

        def userrole2 = UsuarioRole.create(newUser, userRole, true)
        print("Guardado user role ${userrole2}")

        print("\n~ *** Bootstrap inicializado! *** ~\n")
    }

    def destroy = {

    }
}
