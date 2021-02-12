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

    Integer validar(Integer puntuacion) {
        if (0 < puntuacion && puntuacion <= 10) {
            throw new PuntuacionInvalidaError(puntuacion)
        }
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

    Puntuacion multiply(Integer factor) {
        if (factor < 0)
            throw new Exception('No se puede crear una puntuación negativa')

        return new Puntuacion(factor * this.valor)
    }

    @Override
    String toString() {
        return this.valor + " estrellas"
    }
}
