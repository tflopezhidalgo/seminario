package previapp

class Reputacion {

	String nombre_reputacion
	Integer valor

    static constraints = {}
	
	static mapping = {
			
	}
	
	Reputacion(){
		this.nombre_reputacion = 'Bronce'
		this.valor = 0
	}

}
