package previapp

import java.text.DecimalFormat

class Kilometro implements Comparable<Kilometro> {

    BigDecimal cantidad

    Kilometro () { }

    Kilometro(BigDecimal cantidad) {
        this.cantidad = this.validarMonto(cantidad)
        this.cantidad.setScale(2, BigDecimal.ROUND_DOWN)
    }

    BigDecimal validarMonto(BigDecimal cantidad) {
        if (cantidad < 0) {
            throw new KilometroConValorInvalidoError(cantidad)
        }
        cantidad
    }

    @Override
    boolean equals(Object o) {
        return (
            o != null &&
            o.getClass() == Kilometro.class &&
            this.cantidad == (BigDecimal) o.cantidad
        )
    }

    @Override
    String toString() {
        DecimalFormat df = new DecimalFormat()

        df.setMaximumFractionDigits(2)
        df.setMinimumFractionDigits(0)
        df.setGroupingUsed(false)

        df.format(this.cantidad) + "km."
    }

    @Override
    int compareTo(Kilometro that) {
        this.cantidad.compareTo(that.cantidad)
    }

    Kilometro div(Integer denom) {
        if (!denom)
            throw new Exception("No se puede dividir un kilometraje por 0")

        new Kilometro(this.cantidad.div(denom))
    }

    Kilometro plus(Kilometro otro) {
        if (!otro)
            return new Kilometro(this.cantidad)

        new Kilometro(this.cantidad + otro.cantidad)
    }
}
