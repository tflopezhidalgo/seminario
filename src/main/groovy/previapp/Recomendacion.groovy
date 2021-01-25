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
        return this.usuario.calcularAfinidadConLugar(lugar)
    }
}
