package previapp

class Visita {

	String comentarioVisita
	Usuario usuarioVisitante
	Lugar lugarVisitado
	Date fechaDeVisita
	Integer puntuacion

    static constraints = {
		fechaDeVisita nullable: false
    }

	static mapping = {
		table "visitas"
		fechaDeVisita column: 'fecha'
	}
	
	static belongsTo = [usuario: Usuario, lugar: Lugar]

	Visita(String comentario) {
		this.comentarioVisita = comentario
		this.fechaDeVisita = new Date()
	}

	def setComentario(String comentario) {
		this.comentarioVisita = comentario
	}


	def setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion
	}
}
