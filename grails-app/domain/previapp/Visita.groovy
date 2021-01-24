package previapp

import groovy.transform.Sortable

@Sortable(includes = ['fecha'])
class Visita {

    Date fecha
    String comentario
    Puntuacion puntuacion

    static constraints = {
       fecha validator: {
           /* No podemos hacer visitas a futuro */
            fecha, visita -> 
                if (fecha > new Date()) {
                    println("fecha =${fecha} visita=${visita}")
                    return ['fechaDeVisitaInvalida', fecha.toString()] 
                }
        }
    }

    static mapping = {
        table "visitas"
        fecha column: 'fecha'
    }
    
    static embedded = ['puntuacion']
	
    static belongsTo = [usuario: Usuario, lugar: Lugar]

    def esVisitaOro() {
        return this.usuario.esUsuarioOro() 
    } 
}
