package previapp

class Comida {
    String nombre
    Dinero costo

    static embedded = ['costo']

    static constraints = {
        nombre(unique: true, nullable: false)
        costo nullable: false
    }

    static mapping = { 
        table 'comidas'
        nombre nullable: false, unique: true
        costo nullable: false
    }

    Comida(String nombre, Dinero precio) {
        this.costo = precio
        this.nombre = nombre
    }

    String validarNombre(String nombre) {
        if (this.findByNombre(nombre))
            throw new ComidaInvalidaError("Ya existe una comida con ese nombre")

        if (!nombre)
            throw new ComidaInvalidaError("No se pueden crear comidas sin nombre")

        nombre
    }

    Dinero validarCosto(Dinero costo) {
        if (!costo) 
            throw new ComidaInvalidaError("No se pueden crear comidas sin costo")

        costo
    }

    String toString() { nombre }

    Integer calcularSimilitud(Comida otraComida) {
        this.nombre == otraComida.nombre? 10 : 0
    }
}
