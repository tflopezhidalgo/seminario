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

    Visita(Usuario usuario, Lugar lugar, Date fechaVisita, Puntuacion puntuacion, String comentario) {
        if (!(usuario && lugar))
            throw new VisitaInvalidaError("No se puede crear una visita sin usuario o lugar")

        this.fecha = this.validarFecha(fechaVisita)
        this.usuario = usuario
        this.lugar = lugar
        this.puntuacion = puntuacion
        this.comentario = comentario
    }

    Date validarFecha(Date fechaVisita) {
        if (fecha > new Date())
            throw new VisitaInvalidaError("No se pueden crear visitas con fechas en el futuro")

        if (!fecha)
            throw new VisitaInvalidaError("No se puede crear visitas sin fecha")

        fechaVisita
    }

    def esVisitaOro() {
        return this.usuario.esUsuarioOro() 
    } 
}
