package previapp

class LugarInvalidoError extends RuntimeException {
    public LugarInvalidoError(String msg) { 
        super(msg) 
    }
}

class DineroConMontoInvalidoError extends RuntimeException {
    BigDecimal montoErroneo

    public DineroConMontoInvalidoError(BigDecimal monto) {
        this.montoErroneo = monto 
    }
}

class EdadInvalidaError extends RuntimeException {
    Integer edadInvalida

    public EdadInvalidaError(Integer edadInvalida) {
        this.edadInvalida = edadInvalida
    }
}

class PuntuacionInvalidaError extends RuntimeException {
    Integer puntuacionInvalida

    public PuntuacionInvalidaError(Integer puntuacionInvalida) {
        this.puntuacionInvalida = puntuacionInvalida
    }
}

class DireccionInvalidaError extends RuntimeException {
    String direccionInvalida

    public DireccionInvalidaError(String direccionInvalida) {
        this.direccioInvalida = direccionInvalida
    }
}                                   
                                    
class CapacidadMaximaInvalidaError extends RuntimeException {
    Integer capacidadInvalida       
                                    
    public CapacidadMaximaInvalidaError(Integer capacidadInvalida) {
        this.capacidadInvalida = capacidadInvalida
    }
}

class BebidaInvalidaError extends RuntimeException {
    public BebidaInvalidaError(String msg) {
        super(msg)
    }
}

class ComidaInvalidaError extends RuntimeException {
    public ComidaInvalidaError(String msg) {
        super(msg)
    }
}

class MusicaInvalidaError extends RuntimeException {
    public MusicaInvalidaError(String msg) {
        super(msg)
    }
}

class UsuarioInvalidoError extends RuntimeException {
    public UsuarioInvalidoError(String msg) {
        super(msg)
    }
}

class VisitaInvalidaError extends RuntimeException {
    public VisitaInvalidaError(String msg) {
        super(msg)
    }
}

class ZonaInvalidaError extends RuntimeException {
    public ZonaInvalidaError(String msg) {
        super(msg)
    }
}
