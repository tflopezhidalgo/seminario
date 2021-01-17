package previapp

class Comida {
    String nombre
    Dinero costo

    static embedded = ['costo']

    static constraints = {
        nombre(unique:true, nullable: false)
        costo nullable: false
    }

    static mapping = { 
        table 'comidas'
        nombre nullable: false, unique: true
        costo nullable: false
    }

    Comida(String nombre, Dinero precio){
        this.costo = precio
        this.nombre = nombre
    }

    Integer calcularSimilitud(Comida otraComida) {
        if (this.nombre == otraComida.nombre) {
            return 10
        }
        return 0
    }
}
