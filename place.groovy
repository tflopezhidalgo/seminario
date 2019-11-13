

class Place {
	String name
	String direction
	int drinkPrice
	int entryPrice
	int capacity
	String musicType
	int puntuation
	DateTime openHour 

	Place(name, direction) {
		this.name = name
		this.direction = direction
	}

	void setMusicType(String music) {
		this.musicType = music
		// actualizar tabla
	}

	void updatePuntuation() {
		// calculo dependiendo del promedio de gente que puntuo
		// y la calificacion que pusieron
	}

	void getPuntuation() {
		// consultar de la tabla 
		return this.puntuation
	}
}