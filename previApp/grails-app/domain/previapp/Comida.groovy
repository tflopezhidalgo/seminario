package previapp

class Comida {

	String nombre
	Integer costo

    static constraints = {
    	nombre nullable: false
    	costo nullable: false
    }

	static mapping = { 
		table 'comidas'
		id name: 'nombre', generator: 'assigned', type: 'string'

	}

	Comida(String nombre, Integer precio){
		this.costo = costo
		this.nombre = nombre
	}

}
