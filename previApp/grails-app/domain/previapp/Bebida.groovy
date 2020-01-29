package previapp

class Bebida {
	
	/* TODO: Pasar 'costo' a clase Currency/Money */
	String nombre
	Integer costo

	static constraints = {}
	static mapping = {}

	//static belongTo = [lugar: Lugar]

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
