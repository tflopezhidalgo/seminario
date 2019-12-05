
class Puntuacion {
  int puntajePromedio
  int cantidadDeEstrellas
	
  Puntuacion() {	
    this.cantidadDeEstrellas = 0
    this.puntajePromedio = 0
	}

	void actualizar(int puntos) {
		this.cantidadDeEstrellas += 1
    this.puntaje += puntos
    this.puntaje = this.puntaje / this.cantidadDeEstrellas
	}

  int getPuntuacion() {
    return this.puntajePromedio
  }
}