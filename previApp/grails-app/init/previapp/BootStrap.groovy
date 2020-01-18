package previapp

class BootStrap {

    def init = { servletContext ->
        def lugar = new Lugar('Mi casa', 'Ortigoza 283', 20)
        def reputacion = new Reputacion()
        def persona = new Persona('Tomas', 'Lopez', 23)
        def usuario = new Usuario(reputacion, persona)
        def visita = new Visita(persona, lugar)
        usuario.agregarVisita(visita)

        lugar.save()
        persona.save()
        usuario.save()
        visita.save()
    }
    def destroy = {
    }
}
