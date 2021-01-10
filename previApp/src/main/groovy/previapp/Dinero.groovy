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
    int compareTo(Dinero o) {
        int iguales = 0

        int comparacion = this.monto.compareTo(that.monto)
        if ( comparacion != iguales ) return comparacion

        comparacion = this.moneda <=> that.moneda
        if ( comparacion != iguales ) return comparacion

        return iguales
    }
}
