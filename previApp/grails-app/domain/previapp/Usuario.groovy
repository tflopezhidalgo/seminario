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
	}

    static constraints = {
    	nombre nullable: false
		persona nullable: false
    }

    static hasMany = [visitas: Visita]
	static embedded = ['reputacion', 'persona', 'presupuesto']

	Usuario(String nombre, Persona persona, Zona zona, Musica musicaFavorita, Presupuesto presupuesto){
		this.nombre = nombre
		this.reputacion = new Reputacion()
		this.persona = persona
		this.zona = zona
		this.musicaFavorita = musicaFavorita
		this.creacion = new Date()
		this.presupuesto = presupuesto
	}


}



