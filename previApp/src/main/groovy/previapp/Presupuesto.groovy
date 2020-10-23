package previapp

class Presupuesto {

    Integer monto

    Presupuesto(){}

    Presupuesto(Integer monto) {
        this.monto = monto
    }

    boolean esMenorA(Integer monto) {
        this.monto < monto
    }
}
