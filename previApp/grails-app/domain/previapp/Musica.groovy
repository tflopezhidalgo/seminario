package previapp

class Musica {
	List subgeneros
	String genero_musical

    static constraints = {
    }

    Musica(ArrayList subgeneros_musicales, String nombre) {
		this.subgeneros = new ArrayList<Zona>()
		subgeneros_musicales.each { subgenero ->
			this.subgeneros << subgenero
		}
		this.genero_musical = nombre
	}

	def agregarSubgenero(Musica subgenero) {
		this.subgeneros << subgenero
	}

	def getSubgeneros() {
		return this.subgeneros
	}
}
