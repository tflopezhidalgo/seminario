package previapp

class Comida {

	String nombre
	Integer costo

    static constraints = {
    	nombre nullable: false
    	costo nullable: false
    }

    static mapping = {
		// table: "comidas"
		// nombre column: "nombre"
		// costo column: "costo"
	}	

	Comida(Integer costo, String nombre){
		this.costo = costo
		this.nombre = nombre
	}

	def obtenerCosto() {
		return this.costo
	}

}
