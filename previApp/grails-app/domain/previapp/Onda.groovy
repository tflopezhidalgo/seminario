package previapp

class Onda {

	Integer puntaje_match

	Onda() {
		this.puntaje_match = 0
	}

	// la onda se calcula por un solo lugar y usario
	// tendriamos que tener una clase que para un usuario itere sobre todos los lugares disponibles
	// use esta clase para obtener la onda de cada uno
	// los ordene de menor a mayor y me devuelva los primeros 5

	def obtenerOnda(String usuarioNombre, String lugarNombre) {
		def lugar = Lugar.findByNombre(lugarNombre)

		def usuario = Usuario.findByUsuarioNombre(usuarioNombre)

		/*
		if (lugar.obtenerZona() == usuario.obtenerZona()) {
			this.puntaje_match += 2
		}

		lugar.obtenerMusica().each { musica ->
			if (musica == usuario.obtenerMusicaFavorita()) {
				this.puntaje_match += 1
			}
		}

		if (lugar.obtenerPrecio() <= usuario.obtenerPresupuesto()) {
			this.puntaje_match += 3
		}

		if (lugar.obtenerEstrellas() > 3) {
			this.puntaje_match += 1
		} else {
			this.puntaje_match -= 1
		}


		// otras cosas para coinciderar:
		* puntaje del usuario
		* cantidad de visitas que hizo el usuario ese dia
		* obtener edad promedio de usuario que ya visitaron este lugar y ver si esta dentro de la edad del usuario
		*/
	}
}