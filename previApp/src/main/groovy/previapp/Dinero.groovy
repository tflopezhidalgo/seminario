package previapp

import java.text.DecimalFormat

enum Moneda { ARG }

class Dinero implements Comparable<Dinero> {

    BigDecimal monto
    Moneda moneda

    static constraints = {
        monto min: new BigDecimal(0)
    }

    Dinero () { }

    Dinero(BigDecimal monto, Moneda moneda) {
        this.monto = monto
        this.monto.setScale(2, BigDecimal.ROUND_DOWN)
        this.moneda = moneda
    }

    @Override
    boolean equals(Object o) {
        return (
            o != null && 
            o.getClass() == Dinero.class &&
            this.monto == (BigDecimal) o.monto &&
            this.moneda == (Moneda) o.moneda
        )
    }

    @Override
    String toString() {
        DecimalFormat df = new DecimalFormat()

        df.setMaximumFractionDigits(2)
        df.setMinimumFractionDigits(0)
        df.setGroupingUsed(false)

        return df.format(this.monto) + " " + this.moneda.toString()
    }

    @Override
    int compareTo(Dinero that) {
        int iguales = 0

        int comparacion = this.monto.compareTo(that.monto)
        if ( comparacion != iguales ) return comparacion

        comparacion = this.moneda <=> that.moneda
        if ( comparacion != iguales ) return comparacion

        return iguales
    }

    Dinero div(Integer denom) {
        if (!denom)
            throw new Exception("No se puede dividir el Dinero por 0")

        return new Dinero(this.monto.div(denom), this.moneda)
    }

    Dinero plus(Dinero otro) {
        if (!otro)
            return new Dinero(this.monto, this.moneda)

        if (otro.moneda != this.moneda)
            throw new Exception("No se pueden sumar monedas distintas")

        return new Dinero(this.monto + otro.monto, this.moneda)
    }
}
