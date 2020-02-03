package previapp

class Reputacion {

	//	Clase que representa un valor (valor de reputación
	//	y un "rango" -ORO, PLATA, BRONCE- )

	/* TODO: Pasar a tipo enumerativo */
	String nombreReputacion
	Integer puntos

    static constraints = {}
	static mapping = {}

	Reputacion(){
		this.nombreReputacion = 'Bronce'
		this.puntos = 0
	}

	// a medida que el usuario o lugar gana valor, se actualiza su reputacion
	void actualizarReputacion() {
		if (this.puntos >= 50 && this.puntos < 150) {
			nombreReputacion = 'Plata'
		}
		if (this.puntos >= 150) {
			nombreReputacion = 'Oro'
		}
	}

	// sumo puntaje
	void sumarPuntos(Integer cantidad) {
		this.puntos += cantidad
		this.actualizarReputacion()
	}
}


