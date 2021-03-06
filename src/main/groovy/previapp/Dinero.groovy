package previapp

import java.text.DecimalFormat

enum Moneda { ARG }


class Dinero implements Comparable<Dinero> {

    BigDecimal monto
    Moneda moneda

    Dinero () { }

    Dinero(BigDecimal monto, Moneda moneda) {
        this.monto = this.validarMonto(monto)
        this.monto.setScale(2, BigDecimal.ROUND_DOWN)
        this.moneda = moneda
    }

    BigDecimal validarMonto(BigDecimal monto) {
        if (monto < 0) {
            throw new DineroConMontoInvalidoError(monto)
        }
        monto
    }

    @Override
    boolean equals(Object o) {
        o != null &&
        o.getClass() == Dinero.class &&
        this.monto == (BigDecimal) o.monto &&
        this.moneda == (Moneda) o.moneda
    }

    @Override
    String toString() {
        DecimalFormat df = new DecimalFormat()

        df.setMaximumFractionDigits(2)
        df.setMinimumFractionDigits(0)
        df.setGroupingUsed(false)

        df.format(this.monto) + " " + this.moneda.toString()
    }

    @Override
    int compareTo(Dinero that) {
        int iguales = 0

        int comparacion = this.monto.compareTo(that.monto)
        if ( comparacion != iguales ) return comparacion

        comparacion = this.moneda <=> that.moneda
        if ( comparacion != iguales ) return comparacion

        iguales
    }

    Dinero div(Integer denom) {
        if (!denom)
            throw new Exception("No se puede dividir el Dinero por 0")

        new Dinero(this.monto.div(denom), this.moneda)
    }

    Dinero plus(Dinero otro) {
        if (!otro)
            return new Dinero(this.monto, this.moneda)

        if (otro.moneda != this.moneda)
            throw new Exception("No se pueden sumar monedas distintas")

        new Dinero(this.monto + otro.monto, this.moneda)
    }
}
