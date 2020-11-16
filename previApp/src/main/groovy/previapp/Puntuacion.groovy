package previapp

class Puntuacion {

    Integer valor

    static constraints = { 
        valor nullable: false
    }

    Puntuacion() {
        this.valor = 0
    }

    String toString() {
        "${this.valor} estrellas"
    }
}
