package previapp

class Reputacion {

	//	Clase que representa un valor (valor de reputación
	//	y un "rango" -ORO, PLATA, BRONCE- )

	String  nombre
	Integer puntos

	enum Nivel {
		BRONCE, PLATA, ORO
	}

	static constraints = {}
	static mapping = {}

	Reputacion(){
		this.nombre = "${Nivel.MIN_VALUE}"
		this.puntos = 0
	}

	// sumo puntaje
	void sumarPuntos(Integer cantidad) {
		this.puntos += cantidad
		// a medida que el usuario o lugar gana valor, se actualiza su reputacion
		if (this.puntos >= 50 && this.puntos < 150) {
			this.nombre = "${Nivel.MIN_VALUE.next()}"
		}
		if (this.puntos >= 150) {
			this.nombre = "${Nivel.MAX_VALUE}"
		}
	}
}


