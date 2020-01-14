package previapp

class Bebida {
	
	/* TODO: Pasar a clase Currency/Money */
	Integer costo

	static constraints = {
	}

	Bebida(Integer costo) {
		this.costo = costo
	}

	def obtenerCosto() {
		costo
	}

	def setCosto(Integer nuevoCosto) {
		costo = nuevoCosto
	}
}
