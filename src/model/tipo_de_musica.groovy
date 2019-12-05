class TipoDeMusica {
  String genero
  String subgenero
	
  TipoDeMusica(String genero, String subgenero) {
    this.genero    = genero
    this.subgenero = subgenero	
	}

  String getGenero() {
    return this.genero
  }

  String getSubGenero() {
    return this.subgenero
  }

}