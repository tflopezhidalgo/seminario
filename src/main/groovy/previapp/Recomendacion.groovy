package previapp

import groovy.transform.Sortable

@Sortable(includes = ['puntaje'])
class Recomendacion {
    /* Clase responsable de calcular el puntaje para un lugar y un usuario */

    Integer puntaje
    Lugar lugar
    Usuario usuario

    static constraints = {
        puntaje nullable: false
        lugar nullable: false
        usuario nullable: false
    }

    Recomendacion(){}

    Recomendacion(Lugar lugar, Usuario usuario) {
        this.lugar = lugar
        this.usuario = usuario
        this.puntaje = this.calcularPuntaje()
    }

    private Integer calcularPuntaje() {
        // TODO: Hacer algo mejor
        /* TODO: Faltan los campos
         * - Puntaje del usuario
         * - Cantidad de visitas que hizo el usuario en ese dia
         * - Edad promedio de visitantes del lugar
         */

        Integer puntaje = 0

        this.lugar.musica.each { musica ->
            if (musica == usuario.musicaFavorita) {
                puntaje += 1
            }
        }
        
        if (lugar.obtenerPrecioBase() <= usuario.presupuesto.monto){
            puntaje += 3 
        }

        //if (lugar.obtenerEstrellas() > 3) {
        //    this.puntaje += 1
        //} else {
        //    this.puntaje -= 1
        //}

        return puntaje
    }
}
