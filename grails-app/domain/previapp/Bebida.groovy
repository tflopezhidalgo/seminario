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
        this.costo = costo
        this.nombre = this.validarNombre(nombre)
    }

    private String validarNombre(nombre) {
        if (!nombre)
            throw new BebidaInvalidaError("No se puede crear una bebida sin nombre")
        nombre
    }

    String toString() { nombre }

    Integer calcularSimilitud(Bebida otraBebida) {
        this.nombre == otraBebida.nombre? 10 : 0
    }
}
