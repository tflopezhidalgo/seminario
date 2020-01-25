package previapp

class Usuario {

	String usuarioName
	Persona persona
	Reputacion reputacion
	//Persona persona
	//List visitas_realizadas // esto lo sacaria, la clase no tiene que conocer esto, se hace a travez de las tablas
	//List entradas_adquiridas // esto lo sacaria, la clase no tiene que conocer esto, se hace a travez de las tablas y los belongTo

/*	TipoDeMusica[] tipoDeMusica
	Zona nombre_zona
	Date creacion 	*/

	static hasMany = [visitas_realizadas: Visita, 
					  entradas_adquiridas: Entrada]
	
	static mapping = {
		table 'usuarios'
		usuarioNombre unique: true
	}

    static constraints = {
    	username nullable: false
    }

	static embedded = ['reputacion']

	Usuario(String username, Integer edad, String nombre, String apellido='') {
		//this.persona = new Persona(nombre, apellido, edad)
		//this.visitas_realizadas = new ArrayList<Visita>()
		//this.entradas_adquiridas = new ArrayList<Entrada>()
		//this.reputacion = new Reputacion()
	}
/*
	void agregarVisita(Visita visita) {
 		this.visitas_realizadas << visita
	}
*/	
	
}
