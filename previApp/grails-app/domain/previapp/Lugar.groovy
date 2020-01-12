package previapp

class Lugar {

	String nombre
	String direccion
	Reputacion reputacion
	/* TODO: Agregar atributo de horario de atención */
	Integer capacidad_maxima
	Integer cantidad_de_visitas

    static constraints = {}

	Lugar(String nombre, String direccion, Integer puntuacion = 0, Integer capacidad_maxima) {
		this.nombre = nombre
		this.direccion = direccion
		this.puntuacion = puntuacion
		this.capacidad_maxima = capacidad_maxima
	}

}
