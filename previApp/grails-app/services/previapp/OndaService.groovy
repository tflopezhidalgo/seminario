package previapp

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Transactional
class OndaService {

	/* la onda se calcula por un solo lugar y usario
	 * tendriamos que tener una clase que para un usuario itere sobre todos los lugares disponibles
     * use esta clase para obtener la onda de cada uno
	 * los ordene de menor a mayor y me devuelva los primeros 5
	 */

    Onda calcularOnda(Usuario usuario, Lugar lugar) {
		Integer	puntaje = 0

        if (lugar.obtenerZona() == usuario.obtenerZona()) {
            puntaje += 2
        }

        lugar.obtenerMusica().each { musica ->
            if (musica == usuario.obtenerMusicaFavorita()) {
            	puntaje += 1
            }
        }

        if (lugar.obtenerPrecio() <= usuario.obtenerPresupuesto()) {
            puntaje += 3
        }

        if (lugar.obtenerEstrellas() > 3) {
            puntaje += 1
        } else {
            puntaje -= 1
        }


       /* Otras cosas para considerar:
        *  - Puntaje del usuario
        *  - Cantidad de visitas que hizo el usuario ese dia
        *  - Obtener edad promedio de usuario que ya visitaron este lugar y ver si esta dentro de la edad del usuario
        */

    }
}
