package previapp

class Persona {

	String nombre
	String apellido
	Integer edad

	static hasOne = [usuario: Usuario]

    static constraints = {
    	nombre nullable: false
    	apellido nullable: true
    	edad nullable: false
    }

	Persona(String nombre, String apellido, Integer edad){
		this.nombre = nombre
		this.apellido = apellido
		this.edad = edad
	}

}
