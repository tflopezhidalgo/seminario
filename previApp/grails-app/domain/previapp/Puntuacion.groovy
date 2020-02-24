package previapp

class Puntuacion {

	Integer puntajeDelUsuario

    static constraints = {}

	Puntuacion(Integer estrellas) {
		this.puntajeDelUsuario = estrellas
	}

	def getPuntuacion() {
		return this.puntajeDelUsuario
	}
}
