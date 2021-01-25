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

    Integer calcularSimilitud(Musica musica) {
        if (musica.generoMusical == this.generoMusical)
            return 10
        return 0
    }

    String toString() {
        this.generoMusical
    }
}
