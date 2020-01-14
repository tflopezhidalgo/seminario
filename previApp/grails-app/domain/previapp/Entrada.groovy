package previapp

class Entrada {

	Persona persona
	Lugar lugar
	Integer precio

    static constraints = {
    }

	Entrada(Persona persona, Lugar lugar, Integer precio){
		this.persona = persona
		this.lugar = lugar
		this.precio = precio
	}
}
