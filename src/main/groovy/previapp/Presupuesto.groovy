package previapp

class Presupuesto {

    Dinero monto

    Presupuesto(){}

    static embedded = ['monto']

    Presupuesto(Dinero monto) {
        this.monto = monto
    }
}
