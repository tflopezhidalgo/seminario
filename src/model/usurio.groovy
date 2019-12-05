

class User {
	String name
	String direction
	int age
	String ocupation
	String likedMusic

	User(name, age, direction="", likedMusic="", ocupation="") {
		this.name = name
		this.age = age
		this.direction = direction 
		this.likedMusic = likedMusic
		this.ocupation = ocupation
	}

	void setOcupation(String newOcupation) {
		this.ocupation = newOcupation
		// actualizar tabla
	}

	void setLikedMusic(String newLikedMusic) {
		// consultar tabla
		this.likedMusic = newLikedMusic
	}

	String getLikedMusic() {
		// consultar tabla
		return this.likedMusic
	}

	int getAge() {
		// consultar tabla
		return age
	}
}