package previapp

class Persona {

	String nombre
	String apellido
	Integer edad

    static constraints = {
    }

	Persona(String nombre, String apellido, Integer edad){
		this.nombre = nombre
		this.apellido = apellido
		this.edad = edad
	}




}
