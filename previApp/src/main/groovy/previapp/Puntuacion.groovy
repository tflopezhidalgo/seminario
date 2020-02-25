package previapp

class Puntuacion {

	Integer puntajeDelUsuario

	static constraints = { 
		puntajeDelUsuario nullable: false
	}

	static mapping = {
		puntajeDelUsuario nullable: false
	}

	Puntuacion(Integer estrellas) {
		this.puntajeDelUsuario = estrellas
	}

	def getPuntuacion() {
		return this.puntajeDelUsuario
	}
}
