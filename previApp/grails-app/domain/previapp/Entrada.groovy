package previapp

class Entrada {

	Usuario usuario	
	Lugar lugar
	Integer precio

    static constraints = {
    }

	static mapping = {

	}	

	Entrada(Persona persona, Lugar lugar, Integer precio){
		this.persona = persona
		this.lugar = lugar
		this.precio = precio
	}
}
