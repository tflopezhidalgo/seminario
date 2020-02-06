package previapp

class Visita {

	Date fecha_de_visita
	String comentario

    static constraints = {
    	fecha_de_visita nullable: false
    }

	static mapping = {
		table "visitas"
		fecha_de_visita column: 'fecha'
	}
	
	static belongsTo = [usuario: Usuario, lugar: Lugar]

	Visita(String nombre) {
		this.fecha_de_visita = new Date()
		this.comentario = ''
	}

}
