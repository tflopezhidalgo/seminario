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
        puntuacion nullable: true
        entrada nullable: false
    }

    static mapping = {
        table 'lugares'
        nombre nullable: false
        direccion nullabe: false
        descripcion nullabe: true
        capacidadMaxima nullable: true
        puntuacion nullable: true
        entrada nullable: false
    }

    Lugar(String nombre, String direccion, Integer capacidadMaxima) {
        this.puntuacion = new Puntuacion()
        this.nombre = nombre
        this.direccion = direccion
        this.descripcion = ''
        this.capacidadMaxima = capacidadMaxima
        this.entrada = null
    }

    String toString() {
        this.nombre
    }


    def obtenerPrecioBase() {
        def precioBebidas = bebidas.sum { bebida -> bebida.costo } / bebidas.size()
        def precioComidas = comidas.sum { comida -> comida.costo } / comidas.size()

        return precioComidas + precioBebidas + this.entrada.precio
    } 
}
