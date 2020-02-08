package previapp

import groovy.transform.Sortable

@Sortable(includes = ['puntaje'])
class Recomendacion {

	Integer puntaje
	Lugar lugar
	Usuario usuario

    static constraints = {
    }

	Recomendacion(Lugar lugar, Usuario usuario) {
		this.lugar = lugar
		this.usuario = usuario
		this.puntaje = -1
	}

	void calcularPuntaje(Lugar lugar, Usuario usuario) {
		// TODO: Hacer algo mejor
		/* TODO: Faltan los campos
		 * - Puntaje del usuario
		 * - Cantidad de visitas que hizo el usuario en ese dia
		 * - Edad promedio de visitantes del lugar
		 */

		Integer puntaje = 0

		if (lugar.zona == usuario.zona) {
			this.puntaje += 2
		}

		lugar.obtenerMusica().each { musica ->
			if (musica == usuario.obtenerMusicaFavorita()) {
				this.puntaje += 1
			}
		}
		
		if (lugar.obtenerPrecio() <= usuario.obtenerPresupuest()){
			this.puntaje += 3
		}

		if (lugar.obtenerEstrellas() > 3) {
			this.puntaje += 1
		} else {
			this.puntaje -= 1
		}


	}

}
