package previapp

class Bebida {
	
	/* TODO: Pasar a clase Currency/Money */
	String nombre
	Integer costo

	static constraints = {}

	Bebida(Integer costo, String nombre) {
		this.costo = costo
		this.nombre = nombre
	}

	Integer obtenerCosto() {
		return this.costo
	}

	def setCosto(Integer nuevoCosto) {
		this.costo = nuevoCosto
	}
}
