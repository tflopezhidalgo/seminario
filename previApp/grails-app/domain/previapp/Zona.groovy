package previapp

class Zona {
    String nombre

    static constraints = {
        id name: 'nombre', generator: 'assigned', type: 'string'
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
