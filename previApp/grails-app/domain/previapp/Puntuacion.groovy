package previapp

class Puntuacion {

	Integer puntaje_del_usuario

    static constraints = {
    }

	Puntuacion(Integer estrellas) {
		this.puntaje_del_usuario = estrellas
	}

	def getPuntuacion() {
		return this.puntaje_del_usuario
	}

}
