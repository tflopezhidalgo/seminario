package previapp

class Puntuacion {

    Integer valor

    static constraints = { 
        valor min: 1, max: 10
    }

    Puntuacion() {
        this.valor = 1
    }

    Puntuacion(Integer valor) {
        this.valor = valor
    }

    Puntuacion plus(Puntuacion other) {
        if (!other)
            throw new Exception('No se pueden sumar puntuaciones nulas')

        return new Puntuacion(other.valor + this.valor)
    }

    Puntuacion div(Integer denom) {
        if (!denom)
            throw new Exception('No se puede dividir una puntuación por 0')

        return new Puntuacion((this.valor / denom).toInteger())
    }

    @Override
    String toString() {
        return this.valor + " estrellas"
    }
}
