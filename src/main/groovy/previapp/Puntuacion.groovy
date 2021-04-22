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
        this.valor = this.validar(valor)
    }

    private Integer validar(Integer puntuacion) {
        if (0 > puntuacion || puntuacion > 10) {
            throw new PuntuacionInvalidaError(puntuacion)
        }

        puntuacion
    }

    Puntuacion plus(Puntuacion other) {
        if (!other)
            throw new Exception('No se pueden sumar puntuaciones nulas')

        new Puntuacion(other.valor + this.valor)
    }

    Puntuacion div(Integer denom) {
        if (!denom)
            throw new Exception('No se puede dividir una puntuación por 0')

        new Puntuacion((this.valor / denom).toInteger())
    }

    Puntuacion multiply(Integer factor) {
        if (factor < 0)
            throw new Exception('No se puede crear una puntuación negativa')

        new Puntuacion(factor * this.valor)
    }

    @Override
    String toString() {
        this.valor + " estrellas"
    }
}
