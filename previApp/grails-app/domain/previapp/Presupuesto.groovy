package previapp

class Presupuesto {
    Integer monto_presupuesto

    static constraints = {
    }

	Usuario(int monto) {
        this.monto_presupuesto = monto
    }

    def lugarExcedePresupuesto(Lugar lugar) {
        Integer costo_lugar = lugar.obtenerPrecio() // implementar getPrecio()
        return this.excediPresupuesto(costo_lugar)
    }

    def excediPresupuesto(int dineroGastado) {
        if (this.monto_presupuesto < dineroGastado) {
            return true
        }
        return false
    }
}
