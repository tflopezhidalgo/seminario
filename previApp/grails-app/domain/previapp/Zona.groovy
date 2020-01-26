package previapp

class Zona {
	List zonas_cercanas
	String nombre_zona
	//def zonas_cercanas //? esto no se que define

    static constraints = {
    }

	Zona(ArrayList zonas) {
		this.zonas_cercanas = new ArrayList<Zona>()
		zonas.each { zona_aledaña ->
			this.zonas_cercanas << zona_aledaña
		}
	}

	def agregarZona(Zona zona_aledaña) {
		this.zonas_cercanas << zona_aledaña
	}

	def getZonasCercanas() {
		return this.zonas_cercanas
	}
}
