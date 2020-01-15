package previapp

class Usuario {

	Reputacion reputacion
	Persona persona
	List visitas_realizadas
	List entradas_adquiridas

/*	TipoDeMusica[] tipoDeMusica
	Zona nombre_zona
	Date creacion 	*/

	static hasMany = [visitas_realizadas: Visita, 
					  entradas_adquiridas: Entrada]

	static mapping = {
		table 'usuarios'
	}

	static embedded = ['reputacion']

	Usuario(Reputacion reputacion, Persona persona) {
		this.visitas_realizadas = new ArrayList<Visita>()
		this.entradas_adquiridas = new ArrayList<Entrada>()
		this.reputacion = reputacion
		this.persona = persona
	}

	void agregarVisita(Visita visita) {
 		this.visitas_realizadas << visita
	}
	
	
}
