package previapp

class Entrada {

	Usuario usuario	
	Lugar lugar
	Integer precio

    static constraints = {
    	usuario nullable: false
    	lugar nullable: false
    	precio nullable: false
    }

	static mapping = {
		// table: "entradas"
		// lugar column: "lugar_id"
		// usuario column: "usuario_id"
		// precio column: "precio"
	}	

	/*static hasOne = [usuario: Usuario,
					lugar: Lugar
					]
*/
	Entrada(Integer precio){
		//this.persona = persona
		//this.lugar = lugar
		this.precio = precio
	}

	def obtenerPrecio() {
		return this.precio
	}
}
