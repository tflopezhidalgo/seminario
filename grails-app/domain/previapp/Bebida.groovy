package previapp

class Bebida {
    String nombre
    Dinero costo

    static embedded = ['costo']

    static constraints = {
        nombre(unique: true, nullable: false)
        costo nullable: false
    }

    static mapping = { 
        table 'bebidas'
        nombre nullable: false, unique: true
        costo nullable: false
    }

    Bebida(String nombre, Dinero costo) {
        this.costo = this.validarCosto(costo)
        this.nombre = this.validarNombre(nombre)
    }

    Dinero validarCosto(Dinero costo) {
        if(!costo)
            BebidaInvalidaError("No se puede crear una bebida sin costo")
        costo
    }

    String validarNombre(nombre) {
        if(Bebida.findByNombre(nombre))
            throw new BebidaInvalidaError("Ya existe una bebida con ese nombre")

        if (!nombre)
            throw new BebidaInvalidaError("No se puede crear una bebida sin nombre")

        nombre
    }

    String toString() { nombre }

    Integer calcularSimilitud(Bebida otraBebida) {
        this.nombre == otraBebida.nombre? 10 : 0
    }
}
