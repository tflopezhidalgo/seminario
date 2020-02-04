package previapp

class Usuario {

	String nombre
	Reputacion reputacion
	Persona persona

/*	TipoDeMusica[] tipoDeMusica
	Zona nombre_zona
	Date creacion 	*/

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
	static embedded = ['reputacion', 'persona']

	Usuario(String nombre) {
		this.nombre = nombre
		this.reputacion = new Reputacion()
	}

	Usuario(String nombre, Persona persona){
		this.nombre = nombre
		this.persona = persona
		this.reputacion = new Reputacion()
	}


}



