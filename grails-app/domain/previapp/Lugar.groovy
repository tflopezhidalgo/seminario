package previapp

class Lugar {

    String nombre
    String direccion
    String descripcion
    Integer capacidadMaxima
    Puntuacion puntuacion
    Entrada entrada

    static hasMany = [visitas: Visita, comidas: Comida, bebidas: Bebida, musica: Musica] 
    static hasOne = [zona: Zona]
    static embedded = ['puntuacion', 'entrada']

    static constraints = {
        nombre nullable: false
        direccion nullable:false
        descripcion nullable: true
        capacidadMaxima nullable: true, min: 1
        entrada nullable: true
        zona nullable: false
    }

    static mapping = {
        table 'lugares'
        nombre nullable: false
        direccion nullabe: false
        descripcion nullabe: true
        capacidadMaxima nullable: true, min: 1
        entrada nullable: true
        zona nullable: false
    }

    Lugar(String nombre, String direccion, String descripcion, Integer capacidadMaxima, Entrada entrada, Zona zona) {
        this.nombre = this.validarNombre(nombre)
        this.direccion = this.validarDireccion(direccion)
        this.capacidadMaxima = this.validarCapacidad(capacidadMaxima)
        this.puntuacion = new Puntuacion(1)
        this.descripcion = descripcion                    
        this.entrada = entrada                            
        this.zona = this.validarZona(zona)                
    }                                                     
                                                          
    String validarDireccion(String direccion) {
        if (!direccion)
            throw new LugarInvalidoError("No se puede crear un lugar sin dirección")
        //TODO. chequear el caso en que ya hay un lugar con esa dirección
        direccion
    }

    String validarNombre(String nombre) {
        if (!nombre)
            throw new LugarInvalidoError("No se puede crear un lugar sin nombre")
        nombre
    }

    Integer validarCapacidad(Integer capacidadMaxima) {
        if (capacidadMaxima <= 0)
            throw new LugarInvalidoError("No se puede crear un lugar con capacidad máxima negativa o nula")
        capacidadMaxima
    }

    Zona validarZona(Zona zona) {
        if (!zona)
            throw new LugarInvalidoError("No se puede crear un lugar sin una zona")
        zona
    }

    String toString() {
        this.nombre
    }

    def beforeUpdate() { this.calcularPuntuacion() }

    def beforeSave() { this.calcularPuntuacion() }

    def agregarVisita(Visita visita) {
        //TODO.
    }

    def obtenerPrecioBase() {
        def promedioPrecioBebidas = bebidas.sum { bebida -> bebida.costo } / bebidas.size()
        def promedioPrecioComidas = comidas.sum { comida -> comida.costo } / comidas.size()

        (promedioPrecioComidas + promedioPrecioBebidas + this.entrada.precio) / 3
    } 

    /* hook llamado cuando se agrega una visita, recalcula la puntuación del lugar */
    def calcularPuntuacion() {
        def promedioNormal = this.visitas.sum({ 
            visita -> visita.puntuacion
        }) / this.visitas.size()

        def visitasOro = this.visitas?.findAll { visita -> visita.esVisitaOro() }

        /* Las puntuaciones de usuarios ORO son más influyentes */
        def promedioOro = visitasOro? visitasOro.sum({ 
            visita -> visita.puntuacion
        }) / visitasOro.size() : 0

        if (promedioOro)
            this.setPuntuacion((promedioNormal + promedioOro) / 2)
        else
            this.setPuntuacion(promedioNormal)
    }
}
