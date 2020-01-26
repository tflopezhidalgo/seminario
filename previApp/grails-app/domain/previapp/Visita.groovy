package previapp

class Visita {

	String comentario
	Usuario usuario_visitante
	Lugar lugar_visitado
	Date fecha_de_visita
	Integer puntuacion

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

	def setComentario(String comentario) {
		this.comentario = comentario
	}

	def getComentario() {
		return this.comentario
	}

	def setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion
	}

	def getPuntuacion() {
		return this.puntuacion
	}
}
