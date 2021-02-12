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
        this.zona = zona 
    }                                                     
                                                          
    String validarDireccion(String direccion) {
        //TODO: validar que la dirección tenga formato <calle> <numero>
        //TODO. chequear el caso en que ya hay un lugar con esa dirección
        direccion
    }

    String validarNombre(String nombre) {
        //TODO: agregar chequeos por signo de puntuación 
        nombre
    }

    Integer validarCapacidad(Integer capacidadMaxima) {
        if (capacidadMaxima <= 0)
            throw new CapacidadMaximaInvalidaError(capacidadMaxima)
        capacidadMaxima
    }

    String toString() { this.nombre }

    def agregarVisita(Visita visita) {
        /* TODO: casos a revisar:
            - cuando la visita ya está en la lista de visitas
            - cuando se intenta agregar una misma visita de la misma persona en el mismo día 
        */
        if (!visita) {
            throw new NullPointerException("No se puede agregar una visita nula a un lugar")
        }

        this.addToVisitas(visita)
        this.calcularPuntuacion()
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

        if (promedioOro) {
            this.setPuntuacion((promedioNormal + promedioOro) / 2)
        } else {
            this.setPuntuacion(promedioNormal)
        }
    }
}
