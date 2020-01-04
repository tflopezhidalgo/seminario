// Esto fue pensado en principio como una clase abstracta donde cada
// precio implementa los metodos como mas quiere
// pero puede ser que solo varie el costo entre precios
// por lo que habria que ver bien el beneficio de usar aca una clase 
// abstracta
abstract class Precio {         
    int costo

    Precio(int precio) {
        this.costo = precio
    }

    abstract def getCosto() 
    abstract def setCosto() 

}