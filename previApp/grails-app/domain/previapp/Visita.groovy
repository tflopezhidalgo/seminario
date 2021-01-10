package previapp

class Visita {

    Date fecha
    String comentario
    Integer puntuacion

    static constraints = {
        fecha validator: {
            /* No podemos hacer visitas a futuro */
            fecha, visita -> 
                if (fecha > new Date()) {
                    println("fecha =${fecha} visita=${visita}")
                    return ['fechaDeVisitaInvalida', fecha.toString()] 
                }
        }
        puntuacion min: 1, max: 10
    }

    static mapping = {
        table "visitas"
        fecha column: 'fecha'
    }
	
    static belongsTo = [usuario: Usuario, lugar: Lugar]
}
