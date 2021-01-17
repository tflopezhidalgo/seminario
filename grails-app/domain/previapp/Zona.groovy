package previapp

class Zona {
    String nombre

    static mapping = {
        nombre(unique: true, nullable: false)
    }

    static constraints = {
        nombre(unique:true, nullable: false)
    }

    static hasMany = [lugares: Lugar]

    Zona(String nombre){
        this.nombre = nombre
    }

    String toString() {
        this.nombre
    }

    void agregarLugar(Lugar lugar) {
        lugares << lugar
    }

    Integer cantidadDeLugares() {
        return lugares.size()
    }
}
