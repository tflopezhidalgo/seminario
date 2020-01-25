package previapp

class Usuario {

	String nombreUsuario
	//Persona persona
	Reputacion reputacion
	Visita visitas
	Persona persona
	//Persona persona
	//List visitas_realizadas // esto lo sacaria, la clase no tiene que conocer esto, se hace a travez de las tablas
	//List entradas_adquiridas // esto lo sacaria, la clase no tiene que conocer esto, se hace a travez de las tablas y los belongTo

/*	TipoDeMusica[] tipoDeMusica
	Zona nombre_zona
	Date creacion 	*/

	/*static hasMany = [visitas_realizadas: Visita, 
					  entradas_adquiridas: Entrada]
	*/


	static mapping = {
		table 'usuarios'
		nombreUsuario unique: true
		reputacion nullable: true
		visitas nullable: true
	}

    static constraints = {
    	nombreUsuario nullable: false
    }

    static hasMany = [visitas: Visita]

	//static embedded = ['reputacion']

	Usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario
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
