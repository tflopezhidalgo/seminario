
class Puntuacion {
  int puntajePromedio
  int cantidadDeCalificaciones
	
  Puntuacion() {	
    this.cantidadDeCalificaciones = 0
    this.puntajePromedio = 0
	}

	void actualizar(int puntos) {
		this.cantidadDeCalificaciones += 1
    this.puntaje += puntos
    this.puntaje = this.puntaje / this.cantidadDeCalificaciones
	}
}