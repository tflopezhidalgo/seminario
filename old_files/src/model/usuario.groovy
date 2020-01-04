import java.text.SimpleDateFormat

class Usuario {
	String nombre
  Zona nombre_zona
	int edad
	Presupuesto presupuesto
	TipoDeMusica[] tipoDeMusica
  Reputacion reputacion
  Date creacion 

	Usuario(String nombre, int edad, String nombre_zona, String[] tiposMusica, int presupuesto) {
		this.nombre = name
		this.age = age
		this.zona = new Zona(nombre_zona)
		this.tipoDeMusica = 
		this.ocupation = ocupation
        
        def date = new Date()
        sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
        this.creacion = sdf.format(date)

	}

	void setMusicaQueEscucha(String musica_name) {
		// creo un nuevo tipo de musica y lo agrego al array

	}

	void getMusicaQueEscucha(String musica_name) {
        // obtengo de la tabla
	}

	int getEdad() {
		// consultar tabla
		return edad
	}

    int getPresupuesto() {
        return presupuesto.getPresupuesto()
    }

    String getReputacion() {
        // consultar en las tablas de 
        return reputacion.getTipo()
    }
}
