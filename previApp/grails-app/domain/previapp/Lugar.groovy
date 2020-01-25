package previapp

class Lugar {

	String nombre
	String direccion
	//Reputacion reputacion
	/* TODO: Agregar atributo de horario de atención */
	// List visitas
	//Visita visitas
	Usuario usuarios
	Integer capacidad_maxima
	Integer cantidad_de_visitas

    static constraints = {
        nombre nullable: false
        direccion nullable:false
        capacidad_maxima nullable: true
    }

	static mapping = {
		table 'lugares'
		nombre unique: true
	}

	static hasMany = [usuarios: Usuario] // despues usamos la tabla join visitas, la relacion es unilateral

	Lugar(String nombre, String direccion, Integer capacidad_maxima=250) {
		//this.reputacion = new Reputacion()
		// this.visitas = new ArrayList<Visita>()	
		this.nombre = nombre
		this.direccion = direccion
		this.capacidad_maxima = capacidad_maxima
	}

}
