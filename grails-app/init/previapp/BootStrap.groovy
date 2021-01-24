package previapp

class BootStrap {
    MusicaService musicaService
    ComidaService comidaService
    BebidaService bebidaService
    ZonaService zonaService
    UsuarioService usuarioService
    LugarService lugarService
    DummyService dummyService

    def init = { servletContext ->

        /* Música disponible */
        def musicaRock = new Musica('Rock').save(flush: true, failOnError: true)
        def musicaPop = new Musica('Pop').save(flush: true, failOnError: true)
        def musicaNewAge = new Musica('New Age').save(flush: true, failOnError: true)
        def musicaClasica = new Musica('Clasica').save(flush: true, failOnError: true)
        def musicaCumbia = new Musica('Cumbia').save(flush: true, failOnError: true)

        /* Comida y bebida disponible */
        def comidaSushi = new Comida('Sushi', new Dinero(500, Moneda.ARG)).save(flush: true, failOnError: true)
        def comidaHamburguesa = new Comida('Hamburguesas', new Dinero(300, Moneda.ARG)).save(flush: true, failOnError: true)
        def comidaRavioles = new Comida('Plato de Ravioles', new Dinero(130, Moneda.ARG)).save(flush: true, failOnError: true)

        def bebidaCoca = new Bebida('Coca-cola', new Dinero(150, Moneda.ARG)).save(flush: true, failOnError: true)
        def bebidaWhisky = new Bebida('Vaso de whisky', new Dinero(300, Moneda.ARG)).save(flush: true, failOnError: true)
        def bebidaAgua = new Bebida('Vaso de Agua natural', new Dinero(70, Moneda.ARG)).save(flush: true, failOnError: true)
        def bebidaFernet = new Bebida('Vaso de Fernet con Coca Cola', new Dinero(250, Moneda.ARG)).save(flush: true, failOnError: true)

        /* Zonas disponibles */
        def zonaAvellaneda = new Zona('Avellaneda').save(flush: true, failOnError: true)
        def zonaQuilmes = new Zona('Quilmes').save(flush: true, failOnError: true)
        def zonaCapital = new Zona('Capital Federal').save(flush: true, failOnError: true)
	
        /* Lugares disponibles */
        Lugar lugar = new Lugar('Restaurant "El molino"', 'Calle 123', 200)
        lugar.addToComidas(comidaSushi)
        lugar.addToBebidas(bebidaCoca)
        lugar.addToMusica(musicaRock)
        lugar.setZona(zonaCapital)
        lugar.setEntrada(new Entrada(new Dinero(0, Moneda.ARG)))
        lugar.save(failOnError: true)

        Lugar lugar2 = new Lugar('Bar "El bar de Moe"', 'Washington 342', 500)
        lugar2.addToComidas(comidaHamburguesa)
        lugar2.addToBebidas(bebidaCoca)
        lugar2.addToBebidas(bebidaWhisky)
        lugar2.addToMusica(musicaCumbia)
        lugar2.setZona(zonaCapital)
        lugar2.setEntrada(new Entrada(new Dinero(300, Moneda.ARG)))
        lugar2.save(failOnError: true)

        Lugar lugar3 = new Lugar('Tenedor libre "La vaca"', 'Olivos 5121', 300)
        lugar3.addToComidas(comidaHamburguesa)
        lugar3.addToComidas(comidaRavioles)
        lugar3.addToBebidas(bebidaCoca)
        lugar3.addToBebidas(bebidaAgua)
        lugar3.addToMusica(musicaPop)
        lugar3.setZona(zonaCapital)
        lugar3.setEntrada(new Entrada(new Dinero(100, Moneda.ARG)))
        lugar3.save(failOnError: true)

        Lugar lugar4 = new Lugar('Boliche temático 1980', 'Paraguay 500', 1000)
        lugar4.addToComidas(comidaHamburguesa)
        lugar4.addToBebidas(bebidaCoca)
        lugar4.addToBebidas(bebidaWhisky)
        lugar4.addToBebidas(bebidaFernet)
        lugar4.addToMusica(musicaRock)
        lugar4.setZona(zonaCapital)
        lugar4.setEntrada(new Entrada(new Dinero(500, Moneda.ARG)))
        lugar4.save(failOnError: true)

        def persona = new Persona('Tomas', 'Lopez', 23)
        def pr = new Presupuesto(new Dinero(900, Moneda.ARG))
	
        /* Usuarios - roles disponibles */
        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true) 
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)

        def adminUser = Usuario.findByUsername("admin") ?: new Usuario("admin", "admin", persona, zonaCapital, musicaRock, pr).save(failOnError: true)

        def newUser = Usuario.findByUsername("tomas") ?: new Usuario("tomas", "tomas", persona, zonaCapital, musicaRock, pr).save(failOnError: true)

        def goldReputation = new Reputacion([rango: Nivel.ORO, puntos: 4500])
        def goldUser = Usuario.findByUsername("oro") ?: { 
                def usuario = new Usuario("oro", "oro", persona, zonaCapital, musicaRock, pr)
                usuario.setReputacion(goldReputation)
                usuario.save(failOnError: true)
                return usuario 
        }()

        UsuarioRole.create(adminUser, adminRole, true)
        println("¡Creado usuario ${adminUser.username}!")

        UsuarioRole.create(newUser, userRole, true)
        println("¡Creado usuario ${newUser.username}!")

        UsuarioRole.create(goldUser, userRole, true)
        println("¡Creado usuario ${goldUser.username}!")

        print("\n~ *** Bootstrap inicializado! *** ~\n")
    }

    def destroy = {

    }
}
