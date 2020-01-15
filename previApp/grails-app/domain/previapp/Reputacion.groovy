package previapp

class Reputacion {

	//	Clase que representa un valor (valor de reputación
	//	y un "rango" -ORO, PLATA, BRONCE- )

	/* TODO: Pasar a tipo enumerativo */
	String nombre_reputacion
	Integer valor

    static constraints = {}
	
	static mapping = {}
	
	Reputacion(){
		this.nombre_reputacion = 'Bronce'
		this.valor = 0
	}

}
