package previapp

class Entrada {

    Dinero precio

    static embedded = ['precio']

    String toString() {
        precio.toString()
    }

    Entrada(){}

    Entrada(Dinero precio) {
        this.precio = precio
    }
}
