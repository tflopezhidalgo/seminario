package previapp

class Visita {

    Date fecha_de_visita
    String comentario
    Integer puntuacion

    static constraints = {
        fecha_de_visita nullable: false
    }

    static mapping = {
        table "visitas"
        fecha_de_visita column: 'fecha'
    }
	
    static belongsTo = [usuario: Usuario, lugar: Lugar]

    Visita(String nombre) {
        this.nombre_visita = nombre
        this.fecha_de_visita = new Date()
    }
}
