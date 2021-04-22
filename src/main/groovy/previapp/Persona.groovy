package previapp

class Persona {

    final Integer EDAD_MINIMA = 18

    String nombre
    String apellido
    Integer edad

    static constraints = {
        nombre nullable: false
        apellido nullable: false
        edad nullable: false, min: 18
    }

    Persona(){}

    Persona(String nombre, String apellido, Integer edad){
        this.nombre = nombre
        this.apellido = apellido
        this.edad = this.validarEdad(edad)
    }

    private Integer validarEdad(Integer edad) {
        if (edad <= EDAD_MINIMA) {
            throw new EdadInvalidaError(edad)
        }
        edad
    }
}
