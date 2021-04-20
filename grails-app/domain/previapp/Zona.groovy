package previapp

class Zona {
    String nombre

    static hasMany = [lugares: Lugar]

    static mapping = {
        nombre(unique: true, nullable: false)
    }

    static constraints = {
        nombre(unique:true, nullable: false)
    }

    Zona(String nombre){
        if (!nombre)
            throw new ZonaInvalidaError("No se puede crear una zona sin nombre")

        this.nombre = nombre
    }

    String toString() {
        this.nombre
    }

    void agregarLugar(Lugar lugar) {
        lugares << lugar
    }

    Integer cantidadDeLugares() {
        lugares.size()
    }

    Kilometro distanciaConZona(Zona otra) {
        /* Devolvemos una distancia random simulando ubicaciones
         * geográficas
         */
        def randomDistance = new Random()
        new Kilometro(randomDistance.nextInt(100))
    }
}
