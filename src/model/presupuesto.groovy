

class Presupuesto {
	int dinero

	Presupuesto(dinero) {
		this.dinero = dinero
	}

	boolean excedePresupuesto(int costo) {
		// chequear si se tiene suficiente 
    // dinero para pagar el costo
	}

	void pagarCosto(int costo) {
		this.dinero -= costo
	}
}