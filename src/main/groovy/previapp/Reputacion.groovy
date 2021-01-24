package previapp

import grails.gorm.dirty.checking.DirtyCheck

enum Nivel { BRONCE, PLATA, ORO }

@DirtyCheck
class Reputacion {
    //	Clase que representa un valor (valor de reputación
    //	y un "rango" -ORO, PLATA, BRONCE- )

    Nivel   rango
    Integer puntos

    static constraints = {}

    Reputacion(){
        this.rango = Nivel.BRONCE
        this.puntos = 0
    }

    void incrementar(Integer cantidad) {
        setPuntos(this.puntos + cantidad)
        // a medida que el usuario o lugar gana valor, se actualiza su reputacion
        if (this.puntos >= 500 && this.puntos < 1500) {
            setRango(Nivel.PLATA)
        }
        if (this.puntos >= 4500) {
            setRango(Nivel.ORO)
        }
    }

    String toString() {
        "${this.puntos} puntos (${this.rango})"
    }

    Boolean esOro() {
        return (this.rango == Nivel.ORO)
    }
}
