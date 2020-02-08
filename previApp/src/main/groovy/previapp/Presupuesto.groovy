package previapp

class Presupuesto {

	Integer monto

    static constraints = {
		monto nullable: false
    }

	Presupuesto(){
	}

	Presupuesto(Integer monto) {
		this.monto = monto
	}

	boolean esMenorA(Integer monto) {
		this.monto < monto
	}

}
