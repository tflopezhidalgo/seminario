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
        this.nombre = nombre
    }

    String toString() { nombre }

    Integer calcularSimilitud(Bebida otraBebida) {
        if(this.nombre == otraBebida.nombre) {
            return 10
        }
        return 0
    }
}
