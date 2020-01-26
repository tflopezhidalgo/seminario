package previapp

class BootStrap {

    UsuarioService usuarioService
    LugarService lugarService
    PersonaService personaService

    def init = { servletContext ->
        def lugar = new Lugar('Mi casa', 'Ortigoza 283', 20)
        lugar.save()
       
        def reputacion = new Reputacion()
        reputacion.save()
        
        def persona = new Persona('Tomas', 'Lopez', 23)
        persona.save()

        def usuario = new Usuario("Tomas")
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
