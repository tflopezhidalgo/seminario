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
        return 0
    }
}
