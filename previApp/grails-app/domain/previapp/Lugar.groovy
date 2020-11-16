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


    //def obtenerPrecio() {
    //    def precioBebidas = 0
    //    bebidas.each { bebida -> precioBebidas += bebida.obtenerCosto() }
    //    precioBebidas /= bebidas.length

    //    def precioComidad = 0
    //    comidad.each { comida -> precioComidad + = comida.obtenerCosto() }
    //    precioComida /= comidas.length

    //    return precioComida + precioBebidas + entrada.obtenerPrecio()
    //} 
}
