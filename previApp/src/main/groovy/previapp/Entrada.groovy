package previapp

class Entrada {

    Integer precio

    static constraints = {
        precio nullable: false
    }

    static mapping = {
        precio nullable: false
    }

    Entrada(){}

    Entrada(Integer precio) {
        this.precio = precio
    }
}
