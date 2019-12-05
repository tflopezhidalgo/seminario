class Reputacion {
  String antiguedad // fecha de cuando creo la persona su cuenta
  int cantidadDeComentarios
	
  Reputacion(String fechaDeCreacion) {
    this.cantidadDeComentarios = 0	
    this.antiguedad = fechaDeCreacion
	}

  String getAntiguedad() {
    return this.antiguedad
  }

  int getCantidadDeComentarios() {
    return this.cantidadDeComentarios
  }

  void anotarUnComentario() {
    this.cantidadDeComentarios += 1
  }

}