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
        def musicaRockNRoll = new Musica('Rock and roll').save(flush: true, failOnError: true)
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
        def entrada = new Entrada(new Dinero(0, Moneda.ARG)) 
        Lugar lugar = new Lugar('Restaurant "El molino"', 'Calle 123', '', 200, entrada, zonaCapital)
        lugar.addToComidas(comidaSushi)
        lugar.addToComidas(comidaHamburguesa)
        lugar.addToComidas(comidaRavioles)
        lugar.addToBebidas(bebidaCoca)
        lugar.addToMusica(musicaRock)
        lugar.addToMusica(musicaPop)
        lugar.addToMusica(musicaRockNRoll)
        lugar.save(failOnError: true)

        def entrada2 = new Entrada(new Dinero(300, Moneda.ARG))
        Lugar lugar2 = new Lugar('Bar "El bar de Moe"', 'Washington 342', '', 500, entrada2, zonaCapital)
        lugar2.addToComidas(comidaHamburguesa)
        lugar2.addToBebidas(bebidaCoca)
        lugar2.addToBebidas(bebidaWhisky)
        lugar2.addToMusica(musicaCumbia)
        lugar2.addToMusica(musicaRock)
        lugar2.save(failOnError: true)

        def entrada3 = new Entrada(new Dinero(100, Moneda.ARG))
        Lugar lugar3 = new Lugar('Tenedor libre "La vaca"', 'Olivos 5121', '', 300, entrada3, zonaCapital)
        lugar3.addToComidas(comidaHamburguesa)
        lugar3.addToComidas(comidaRavioles)
        lugar3.addToBebidas(bebidaCoca)
        lugar3.addToBebidas(bebidaAgua)
        lugar3.addToMusica(musicaPop)
        lugar3.save(failOnError: true)

        def entrada4 = new Entrada(new Dinero(500, Moneda.ARG))
        Lugar lugar4 = new Lugar('Boliche temático 1980', 'Paraguay 500', '', 1000, entrada4, zonaCapital)
        lugar4.addToComidas(comidaHamburguesa)
        lugar4.addToBebidas(bebidaCoca)
        lugar4.addToBebidas(bebidaWhisky)
        lugar4.addToBebidas(bebidaFernet)
        lugar4.addToMusica(musicaRock)
        lugar4.addToMusica(musicaRockNRoll)
        lugar4.save(failOnError: true)

        def entrada5 = new Entrada(new Dinero(0, Moneda.ARG))
        Lugar lugar5 = new Lugar('Bar "La birra fría"', 'Alberdi 500', '', 100, entrada5, zonaCapital)
        lugar5.addToComidas(comidaHamburguesa)
        lugar5.addToBebidas(bebidaCoca)
        lugar5.addToBebidas(bebidaWhisky)
        lugar5.addToBebidas(bebidaFernet)
        lugar5.addToMusica(musicaRock)
        lugar5.addToMusica(musicaPop)
        lugar5.addToMusica(musicaCumbia)
        lugar5.save(failOnError: true)

        def entrada6 = new Entrada(new Dinero(0, Moneda.ARG))
        Lugar lugar6 = new Lugar("Restaurant 'El salóm ahumado'", 'Corrientes 500', '', 100, entrada6, zonaCapital)
        lugar6.addToComidas(comidaHamburguesa)
        lugar6.addToComidas(comidaRavioles)
        lugar6.addToComidas(comidaSushi)
        lugar6.addToBebidas(bebidaCoca)
        lugar6.addToBebidas(bebidaWhisky)
        lugar6.addToBebidas(bebidaFernet)
        lugar6.addToMusica(musicaRock)
        lugar6.addToMusica(musicaClasica)
        lugar6.save(failOnError: true)

        def entrada7 = new Entrada(new Dinero(800, Moneda.ARG))
        Lugar lugar7 = new Lugar('Boliche 1982', 'Av. Mitre 1500', '', 100, entrada7, zonaCapital)
        lugar7.addToComidas(comidaHamburguesa)
        lugar7.addToBebidas(bebidaCoca)
        lugar7.addToBebidas(bebidaWhisky)
        lugar7.addToBebidas(bebidaFernet)
        lugar7.addToMusica(musicaRock)
        lugar7.addToMusica(musicaRockNRoll)
        lugar7.addToMusica(musicaClasica)
        lugar7.save(failOnError: true)

        def entrada8 = new Entrada(new Dinero(400, Moneda.ARG))
        Lugar lugar8 = new Lugar('La Birra bar', 'Ruta 2, Km 200', '', 100, entrada8, zonaCapital)
        lugar8.addToComidas(comidaHamburguesa)
        lugar8.addToBebidas(bebidaCoca)
        lugar8.addToBebidas(bebidaWhisky)
        lugar8.addToBebidas(bebidaFernet)
        lugar8.addToMusica(musicaRock)
        lugar8.save(failOnError: true)

        def entrada9 = new Entrada(new Dinero(500, Moneda.ARG))
        Lugar lugar9 = new Lugar('Antares', 'Perú 1200', '', 100, entrada9, zonaCapital)
        lugar9.addToComidas(comidaHamburguesa)
        lugar9.addToBebidas(bebidaCoca)
        lugar9.addToBebidas(bebidaWhisky)
        lugar9.addToBebidas(bebidaFernet)
        lugar9.addToMusica(musicaRock)
        lugar9.addToMusica(musicaNewAge)
        lugar9.addToMusica(musicaPop)
        lugar9.save(failOnError: true)

        def entrada10 = new Entrada(new Dinero(1500, Moneda.ARG)) 
        Lugar lugar10 = new Lugar('Restaurant "Los tres mosqueteros"', 'Colombres 1253', '', 100, entrada10, zonaCapital)
        lugar10.addToComidas(comidaHamburguesa)
        lugar10.addToComidas(comidaRavioles)
        lugar10.addToBebidas(bebidaCoca)
        lugar10.addToBebidas(bebidaWhisky)
        lugar10.addToBebidas(bebidaFernet)
        lugar10.addToMusica(musicaNewAge)
        lugar10.save(failOnError: true)

        def entrada11 = new Entrada(new Dinero(200, Moneda.ARG))
        Lugar lugar11 = new Lugar('Bodegón "El antiguo"', 'Av. Calchaquí 33', '', 100, entrada11, zonaAvellaneda)
        lugar11.addToComidas(comidaRavioles)
        lugar11.addToComidas(comidaHamburguesa)
        lugar11.addToBebidas(bebidaCoca)
        lugar11.addToBebidas(bebidaWhisky)
        lugar11.addToBebidas(bebidaFernet)
        lugar11.addToMusica(musicaClasica)
        lugar11.save(failOnError: true)

        def entrada12 = new Entrada(new Dinero(700, Moneda.ARG))
        Lugar lugar12 = new Lugar('Restaurant temático 123', 'Ecuador 1253', '', 100, entrada12, zonaAvellaneda)
        lugar12.addToComidas(comidaHamburguesa)
        lugar12.addToBebidas(bebidaCoca)
        lugar12.addToBebidas(bebidaWhisky)
        lugar12.addToBebidas(bebidaFernet)
        lugar12.addToMusica(musicaRock)
        lugar12.addToMusica(musicaPop)
        lugar12.save(failOnError: true)

        def entrada13 = new Entrada(new Dinero(100, Moneda.ARG))
        Lugar lugar13 = new Lugar('Bodegón "El más antiguo II"', 'Av. Mitre 1242', '', 100, entrada13, zonaAvellaneda)
        lugar13.addToComidas(comidaHamburguesa)
        lugar13.addToBebidas(bebidaCoca)
        lugar13.addToBebidas(bebidaWhisky)
        lugar13.addToBebidas(bebidaFernet)
        lugar13.addToMusica(musicaClasica)
        lugar13.save(failOnError: true)

        def entrada14 = new Entrada(new Dinero(600, Moneda.ARG))
        Lugar lugar14 = new Lugar('Boliche Goa La France', 'Av. sarmiento 1202', '', 100, entrada14, zonaAvellaneda)
        lugar14.addToComidas(comidaHamburguesa)
        lugar14.addToBebidas(bebidaCoca)
        lugar14.addToBebidas(bebidaWhisky)
        lugar14.addToBebidas(bebidaFernet)
        lugar14.addToMusica(musicaCumbia)
        lugar14.addToMusica(musicaPop)
        lugar14.save(failOnError: true)

        def entrada15 = new Entrada(new Dinero(900, Moneda.ARG))
        Lugar lugar15 = new Lugar('Boliche "The disco"', 'Av. Lima 1300', '', 100, entrada15, zonaAvellaneda)
        lugar15.addToComidas(comidaHamburguesa)
        lugar15.addToBebidas(bebidaCoca)
        lugar15.addToBebidas(bebidaWhisky)
        lugar15.addToBebidas(bebidaFernet)
        lugar15.addToMusica(musicaRockNRoll)
        lugar15.save(failOnError: true)

        def persona = new Persona('Tomas', 'Lopez', 23)
        def pr = new Presupuesto(new Dinero(900, Moneda.ARG))
	
        /* Usuarios - roles disponibles */
        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true) 
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)

        def adminUser = Usuario.findByUsername("admin") ?: {
            def newUsuario = new Usuario("admin", "admin", persona, zonaCapital, musicaRock, pr)
            newUsuario.setComidaFavorita(comidaHamburguesa)
            newUsuario.setBebidaFavorita(bebidaWhisky)
            return newUsuario
        }().save(failOnError: true)

        def newUser = Usuario.findByUsername("tomas") ?: {
            def newUsuario = new Usuario("tomas", "tomas", persona, zonaCapital, musicaRock, pr)
            newUsuario.setComidaFavorita(comidaSushi)
            newUsuario.setBebidaFavorita(bebidaAgua)
            return newUsuario
        }().save(failOnError: true)

        def goldReputation = new Reputacion([rango: Nivel.ORO, puntos: 4500])
        def goldUser = Usuario.findByUsername("oro") ?: { 
            def usuario = new Usuario("oro", "oro", persona, zonaCapital, musicaRock, pr)
            usuario.setReputacion(goldReputation)
            usuario.save(failOnError: true)
            return usuario 
        }()

        UsuarioRole.create(adminUser, adminRole, true)
        log.info("Creado usuario ${adminUser.username}")

        UsuarioRole.create(newUser, userRole, true)
        log.info("Creado usuario ${newUser.username}")

        UsuarioRole.create(goldUser, userRole, true)
        log.info("Creado usuario ${goldUser.username}")
    }

    def destroy = {

    }
}
