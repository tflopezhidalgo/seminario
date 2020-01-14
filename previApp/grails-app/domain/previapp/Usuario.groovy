package previapp

class Usuario {

	Reputacion reputacion
	Persona persona
	def lugares_visitados

/*	TipoDeMusica[] tipoDeMusica
	Zona nombre_zona
	Date creacion 	*/

    static constraints = {
    }

	static mapping = {
		table 'usuarios'
		reputacion column: 'reputacion', type: 'integer', sqlType: 'integer'
	}

	Usuario() {
		

	}
	
	
}
