package previapp

class Musica {

    String generoMusical

    static constraints = {
        generoMusical nullable: false
    }

    static mapping = {
        table 'musica'
        generoMusical(unique: true, nullable: false)
    }

    Musica(String generoMusical) {
        this.generoMusical = generoMusical
    }

    String validarGenero(String generoMusical) {
        if (!generoMusical) 
            throw new MusicaInvalidaError("No se puede crear un género musical sin nombre")

        if(this.findByGeneroMusical(generoMusical))
            throw new MusicaInvalidaError("Ya existe ese género musical")

        generoMusical
    }

    Integer calcularSimilitud(Musica musica) {
        musica.generoMusical == this.generoMusical? 10 : 0
    }

    String toString() {
        this.generoMusical
    }
}
