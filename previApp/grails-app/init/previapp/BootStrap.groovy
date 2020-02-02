package previapp

class BootStrap {

    UsuarioService usuarioService
    LugarService lugarService
    PersonaService personaService

    def init = { servletContext ->

		Musica musica = new Musica('Rock')
		musica.save()

		Comida comida = new Comida('Sushi', 25)
		comida.save()

		Bebida bebida = new Bebida('Coca-cola', 250)
		bebida.save()

        def lugar = new Lugar('Mi casa', 'Ortigoza 283', 20)
        lugar.save()
       
        def persona = new Persona('Tomas', 'Lopez', 23)
        persona.save()

        def usuario = new Usuario("Tomas", persona)
          // .addToPersona(nombre: "Tomas", apellido: "Lopez", edad: 23)
          //  .addToReputacion(reputacion)
        usuario.save()

        //def visita = new Visita(persona, lugar)
        //usuario.agregarVisita(visita)

        //visita.save()
    }
    def destroy = {
    }
}
