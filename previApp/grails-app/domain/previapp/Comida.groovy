package previapp

class Comida {

	String nombre
	Integer costo

    static constraints = {}

	Comida(Integer costo, String nombre){
		this.costo = costo
		this.nombre = nombre
	}

}
