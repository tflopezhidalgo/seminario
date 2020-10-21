package previapp

class Zona {
    String nombre

    static mapping = {
        nombre nullable: false
    }

    static constraints = {
        nombre nullable: false
    }

    static hasMany = [lugares: Lugar]

    Zona(String nombre){
        this.nombre = nombre
    }

    void agregarLugar(Lugar lugar) {
        lugares << lugar
    }

    Integer cantidadDeLugares() {
        return lugares.size()
    }
}
