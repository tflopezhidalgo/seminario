package previapp

import groovy.transform.Sortable
import groovy.transform.ToString

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

    private Integer calcularPuntaje() {
        this.usuario.calcularAfinidadConLugar(lugar)
    }

    Recomendacion(){}

    Recomendacion(Lugar lugar, Usuario usuario) {
        this.lugar = lugar
        this.usuario = usuario
        this.puntaje = this.calcularPuntaje()
    }

    @Override
    String toString() {
        "Recomendacion (${this.puntaje}): ${this.usuario} -> ${this.lugar}\n"
    }
}
