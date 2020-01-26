package previapp

class Reputacion {

	//	Clase que representa un valor (valor de reputación
	//	y un "rango" -ORO, PLATA, BRONCE- )

	/* TODO: Pasar a tipo enumerativo */
	String nombre_reputacion
	Integer puntos

    static constraints = {}
	static mapping = {}
	static belongTo = [usuario: Usuario]  
	
	Reputacion(){
		this.nombre_reputacion = 'Bronce'
		this.puntos = 0
	}

	// a medida que el usuario o lugar gana valor, se actualiza su reputacion
	def actualizar_reputacion() {
		if (this.puntos >= 50 && this.puntos < 150) {
			nombre_reputacion = 'Plata'
		}
		if (this.puntos >= 150) {
			nombre_reputacion = 'Oro'
		}
	}

	// sumo puntaje
	def sumar_puntos(Integer cantidad) {
		this.puntos += cantidad
	}
}
