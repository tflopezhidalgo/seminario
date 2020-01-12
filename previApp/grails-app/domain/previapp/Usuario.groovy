package previapp

class Usuario {

	Reputacion reputacion
	Persona persona
	def lugares_visitados

    static constraints = {
    }

	static mapping = {
		table 'usuarios'
		reputacion column: 'reputacion', type: 'integer', sqlType: 'integer'
	}
	
}
