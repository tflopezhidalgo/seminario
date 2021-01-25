package previapp

class Lugar {

    String nombre
    String direccion
    String descripcion
    Integer capacidadMaxima
    Puntuacion puntuacion
    Entrada entrada
    //TODO: Agregar atributo de horario de atención

    static hasMany = [visitas: Visita, comidas: Comida, bebidas: Bebida, musica: Musica] 
    static hasOne = [zona: Zona]
    static embedded = ['puntuacion', 'entrada']

    static constraints = {
        nombre nullable: false
        direccion nullable:false
        descripcion nullable: true
        capacidadMaxima nullable: true
        puntuacion nullable: false
        entrada nullable: false
    }

    static mapping = {
        table 'lugares'
        nombre nullable: false
        direccion nullabe: false
        descripcion nullabe: true
        capacidadMaxima nullable: true
        puntuacion nullable: false
        entrada nullable: false
    }

    Lugar(String nombre, String direccion, Integer capacidadMaxima) {
        this.puntuacion = new Puntuacion(1)
        this.nombre = nombre
        this.direccion = direccion
        this.descripcion = ''
        this.capacidadMaxima = capacidadMaxima
        this.entrada = null
    }

    String toString() {
        this.nombre
    }

    def beforeUpdate() { this.calcularPuntuacion() }

    def beforeSave() { this.calcularPuntuacion() }

   def obtenerPrecioBase() {
        def promedioPrecioBebidas = bebidas.sum { bebida -> bebida.costo } / bebidas.size()
        def promedioPrecioComidas = comidas.sum { comida -> comida.costo } / comidas.size()

        return (promedioPrecioComidas + promedioPrecioBebidas + this.entrada.precio) / 3
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
