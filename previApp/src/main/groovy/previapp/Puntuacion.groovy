package previapp

class Puntuacion {

    Integer puntajeDelUsuario

    static constraints = { 
        puntajeDelUsuario nullable: false
    }

    Puntuacion(Integer estrellas) {
        this.puntajeDelUsuario = estrellas
    }

    def getPuntuacion() {
        this.puntajeDelUsuario
    }
}
