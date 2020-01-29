package previapp

class Usuario {

	String nombre_usuario
	Reputacion reputacion
	Persona persona

/*	TipoDeMusica[] tipoDeMusica
	Zona nombre_zona
	Date creacion 	*/

	static mapping = {
		table 'usuarios'
		id name: 'nombre_usuario', generator: 'assigned', type: 'string'
		reputacion nullable: true
	}

    static constraints = {
    	nombre_usuario nullable: false
    }

    static hasMany = [visitas: Visita]
	static embedded = ['reputacion', 'persona']

	Usuario(String nombreUsuario) {
		this.nombre_usuario = nombreUsuario
		//this.persona = new Persona(nombre, apellido, edad)
		//this.visitas_realizadas = new ArrayList<Visita>()
		//this.entradas_adquiridas = new ArrayList<Entrada>()
		this.reputacion = new Reputacion()
	}

	Usuario(String nombreUsuario, Persona persona){
		this.nombre_usuario = nombreUsuario
		this.persona = persona
		this.reputacion = new Reputacion()
	}


}
