package previapp

class Usuario {

	String nombre
	Reputacion reputacion
	Persona persona
	Zona zona
	Musica musica_favorita
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

	Usuario(String nombre) {
		this.nombre = nombre
		this.reputacion = new Reputacion()
	}

	Usuario(String nombre, Persona persona, Zona zona, Musica musica_favorita, Presupuesto presupuesto){
		this.nombre = nombre
		this.reputacion = new Reputacion()
		this.persona = persona
		this.zona = zona
		this.musica_favorita = musica_favorita
		this.creacion = new Date()
		this.presupuesto = presupuesto
	}


}



