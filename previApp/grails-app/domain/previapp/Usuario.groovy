package previapp

class Usuario {

	Reputacion reputacion
	Persona persona
	def visitas_realizadas

/*	TipoDeMusica[] tipoDeMusica
	Zona nombre_zona
	Date creacion 	*/

	static hasMany = [visitas : Visita]

	static mapping = {
		table 'usuarios'
	}

	static embedded = ['reputacion']

	Usuario(Reputacion reputacion, Persona persona) {
		this.lugares_visitados = []
		this.reputacion = reputacion
		this.persona = persona
	}

	void agregarVisita(Visita visita) {
 		this.visitas_realizadas << visita
	}
	
	
}
