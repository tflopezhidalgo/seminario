package previapp

class Bebida {
	
	/* TODO: Pasar 'costo' a clase Currency/Money */
	String nombre
	Integer costo

	static constraints = {
		nombre nullable: false
		costo nullable: false
	}

	static mapping = { 
		table 'bebidas'
		id name: 'nombre', generator: 'assigned', type: 'string'
	}

	Bebida(String nombre, Integer costo) {
		this.costo = costo
		this.nombre = nombre
	}

	Integer calcularSimilitud(Bebida bebida) {

		return 0
	}

}
