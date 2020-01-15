package previapp

class Visita {

	Persona persona_visitante
	Lugar lugar_visitado
	Date fecha_de_visita

    static constraints = {
    }

	static mapping = {
		fecha_de_visita column: 'fecha'
	}

	Visita(){
	}

}
