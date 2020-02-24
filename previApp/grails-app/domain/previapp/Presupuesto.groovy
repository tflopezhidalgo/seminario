package previapp

class Presupuesto {
    Integer montoPresupuesto

    static constraints = {
    }

	Presupuesto(int monto) {
        this.montoPresupuesto = monto
    }

    def lugarExcedePresupuesto(Lugar lugar) {
        Integer costo_lugar = lugar.obtenerPrecio() // implementar getPrecio()
        return this.excediPresupuesto(costo_lugar)
    }

    def excediPresupuesto(int dineroGastado) {
        if (this.montoPresupuesto < dineroGastado) {
            return true
        }
        return false
    }
}
