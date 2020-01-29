package previapp

class Lugar {

	String nombre
	String direccion
	/* TODO: Agregar atributo de horario de atención */
	Puntuacion puntuacion
	Integer capacidad_maxima

	static hasMany = [visitas: Visita] 

    static constraints = {
        nombre nullable: false
        direccion nullable:false
        capacidad_maxima nullable: true
    }

	static mapping = {
		table 'lugares'
		id name: 'nombre', type: 'string', generator: 'assigned'  // Declara la primary key de la tabla
	}

	Lugar(String nombre, String direccion, Integer capacidad_maxima=250) {
		this.puntuacion = new Puntuacion()
		this.nombre = nombre
		this.direccion = direccion
		this.capacidad_maxima = capacidad_maxima
	}


	/*
	def obtenerPrecio() {
		def precioBebidas = 0
		bebidas.each { bebida ->
			precioBebidas += bebida.obtenerCosto()
		}
		precioBebidas /= bebidas.length

		def precioComidad = 0
		comidad.each { comida -> 
			precioComidad + = comida.obtenerCosto()
		}
		precioComida /= comidas.length

		return precioComida + precioBebidas + entrada.obtenerPrecio()
	}
	*/
}
