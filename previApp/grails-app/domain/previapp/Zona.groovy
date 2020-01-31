package previapp

class Zona {

	String nombre
	static hasMany = [lugares: Lugar]

    static constraints = {
		id name: 'nombre', generator: 'assigned', type: 'string'
    }

	Zona(String nombre){
		this.nombre = nombre
	}

	void agregarLugar(Lugar lugar) {	
		lugares << lugar
	}


}
