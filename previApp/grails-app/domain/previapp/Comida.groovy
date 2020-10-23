package previapp

class Comida {

    String nombre
    Integer costo

    static constraints = {
        nombre(unique:true, nullable: false)
        costo nullable: false
    }

    static mapping = { 
        table 'comidas'
        nombre nullable: false, unique: true
        costo nullable: false
    }

    Comida(String nombre, Integer precio){
        this.costo = precio
        this.nombre = nombre
    }

    Integer calcularSimilitud(Comida comida) {
        return 0
    }
}
