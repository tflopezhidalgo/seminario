package previapp

class Bebida {
	
    /* TODO: Pasar 'costo' a clase Currency/Money */
    String nombre
    Integer costo

    static constraints = {
        nombre(unique: true, nullable: false)
        costo nullable: false
    }

    static mapping = { 
        table 'bebidas'
        nombre nullable: false, unique: true
        costo nullable: false
    }

    Bebida(String nombre, Integer costo) {
        this.costo = costo
        this.nombre = nombre
    }

    Integer calcularSimilitud(Bebida bebida) {
        return 0
    }
}
