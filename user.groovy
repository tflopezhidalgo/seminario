

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
		ocupation = newOcupation
	}

	void setLikedMusic(String newLikedMusic) {
		likedMusic = newLikedMusic
	}

	String getLikedMusic() {
		return likedMusic
	}

	int getAge() {
		return age
	}
}