package previapp

class Comida {

	String nombre
	Integer costo

    static constraints = {
    	nombre nullable: false
    	costo nullable: false
    }

	Comida(Integer costo, String nombre){
		this.costo = costo
		this.nombre = nombre
	}

}
