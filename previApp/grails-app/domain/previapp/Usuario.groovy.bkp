package previapp

class Usuario {

    String nombre
    Reputacion reputacion
    Persona persona
    Zona zona
    Musica musicaFavorita
    Date creacion
    Presupuesto presupuesto

    static mapping = {
        table 'usuarios'
        id name: 'nombre', generator: 'assigned', type: 'string'
        reputacion nullable: true
        persona nullable: false
        zona nullable: false
        musicaFavorita nullable: false
        creacion nullable: false
        presupuesto nullable: false
    }

    static constraints = {
        nombre nullable: false
        reputacion nullable: false
        persona nullable: false
        zona nullable: false
        musicaFavorita nullable: true
        creacion nullable: false
        presupuesto nullable: true
    }

    static hasMany = [visitas: Visita]
    static embedded = ['reputacion', 'persona', 'presupuesto']

    Usuario(String nombre, Persona persona, Zona zona, Musica musicaFavorita, Presupuesto presupuesto) {
        this.nombre = nombre
        this.reputacion = new Reputacion()
        this.persona = persona
        this.zona = zona
        this.musicaFavorita = musicaFavorita
        this.presupuesto = presupuesto
        this.creacion = new Date()
    }
}
