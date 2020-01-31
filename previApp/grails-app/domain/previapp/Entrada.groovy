package previapp

class Entrada {

	Integer precio
	Date fechaDeCompra
	Date fechaDeEvento

    static constraints = {
		usuario nullable: true
    	lugar nullable: false
    	precio nullable: false
    }

	static mapping = {
		// table: "entradas"
		// lugar column: "lugar_id"
		// usuario column: "usuario_id"
		// precio column: "precio"
	}	

	static belongsTo = [lugar: Lugar]
	static hasOne = [usuario: Usuario]

	Entrada(Integer precio, Date fechaDeEvento) {
		this.fechaDeEvento = fechaDeEvento
		this.precio = precio
	}

	boolean fueAdquirida() {
		// TODO: Devolver si existe un usuario asignado	
	}

	void adquirir(Usuario usuario) {
		this.fechaDeCompra = new Date()
		this.usuario = usuario
	}

}
