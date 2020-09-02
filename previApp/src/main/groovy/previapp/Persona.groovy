package previapp 

class Persona {

    String nombre
    String apellido
    Integer edad

    static constraints = {
        nombre nullable: false
        apellido nullable: false
        edad nullable: false
    }

    static mapping = {
        nombre nullable: false
        apellido nullable: false
        edad nullable: false
    }

    Persona(){}

    Persona(String nombre, String apellido, Integer edad){
        this.nombre = nombre
        this.apellido = apellido
        this.edad = edad
    }
}
