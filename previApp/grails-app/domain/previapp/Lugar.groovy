package previapp

class Lugar {

    String nombre
    String direccion
    String descripcion
    /* TODO: Agregar atributo de horario de atención */
    Puntuacion puntuacion
    Integer capacidadMaxima
    Entrada entrada

    static hasMany = [visitas: Visita, comidas: Comida, bebidas: Bebida, musica: Musica] 
    static hasOne = [zona: Zona]
    static embedded = ['puntuacion', 'entrada']

    static constraints = {
        nombre nullable: false
        direccion nullable:false
        capacidadMaxima nullable: true
        entrada nullable: true
        descripcion nullable: true
        puntuacion nullable: true
    }

    static mapping = {
        table 'lugares'
        id name: 'nombre', type: 'string', generator: 'assigned'  // Declara la primary key de la tabla
        direccion nullabe: false
        capacidadMaxima nullable: true
        entrada nullable: true
        descripcion nullabe: true
        puntuacion nullable: true
    }

    Lugar(String nombre, String direccion, Integer capacidadMaxima) {
        this.puntuacion = null
        this.nombre = nombre
        this.direccion = direccion
        this.descripcion = ''
        this.capacidadMaxima = capacidadMaxima
        this.entrada = null 
    }

/*  Lugar(String nombre, String direccion, Integer capacidadMaxima=250, Entrada entrada) {
        this.puntuacion = new Puntuacion()
        this.nombre = nombre
        this.descripcion = ''
        this.direccion = direccion
        this.capacidadMaxima = capacidadMaxima
        this.entrada = entrada
    }

    /*
    def obtenerPrecio() {
        def precioBebidas = 0
        bebidas.each { bebida -> precioBebidas += bebida.obtenerCosto() }
        precioBebidas /= bebidas.length

        def precioComidad = 0
        comidad.each { comida -> precioComidad + = comida.obtenerCosto() }
        precioComida /= comidas.length

        return precioComida + precioBebidas + entrada.obtenerPrecio()
    } */
}
