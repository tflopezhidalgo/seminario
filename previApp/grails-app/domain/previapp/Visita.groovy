package previapp

class Visita {

	Usuario usuario_visitante
	Lugar lugar_visitado
	Date fecha_de_visita

    static constraints = {
    	usuario_visitante nullable: false
    	lugar_visitado nullable: false
    	date nullable: false
    }

	static mapping = {
		table "visitas"
		usuario_visitante column: 'usuario_id'
		lugar_visitado column: 'lugar_id'
		fecha_de_visita column: 'fecha'
	}

	static belongTo = [	usuario_visitante: Usuario,
						lugar_visitado: Lugar
					]
	/*
	Visita(Persona persona, Lugar lugar) {
		this.persona_visitante = persona
		this.lugar_visitado = lugar
		this.fecha_de_visita = new Date()
	}
	*/
}
