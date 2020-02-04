package previapp

class Visita {

	String comentario_visita
	Usuario usuario_visitante
	Lugar lugar_visitado
	Date fecha_de_visita
	Integer puntuacion
	Date fecha_de_visita

    static constraints = {
    	fecha_de_visita nullable: false
    }

	static mapping = {
		table "visitas"
		fecha_de_visita column: 'fecha'
	}
	
	static belongsTo = [usuario: Usuario, lugar: Lugar]

	Visita(String comentario) {
		this.comentario_visita = comentario
		this.fecha_de_visita = new Date()
	}

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
