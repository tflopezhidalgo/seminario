package previapp

class Musica {

	String generoMusical

    static constraints = {
		generoMusical nullable: false
    }

	static mapping = {
		table 'musica'
		id name: 'generoMusical', generator: 'assigned', type: 'string'
	}

	Musica(String generoMusical) {
		this.generoMusical = generoMusical
	}


	Integer calcularSimilitud(Musica musica) {

		return 0
	}
}
