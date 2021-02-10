package previapp

import grails.gorm.services.Service

@Service(Lugar)
abstract class LugarService {

    abstract Lugar get(Serializable id)

    abstract List<Lugar> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Lugar save(Lugar lugar)

    Lugar crearLugar(Map caracteristicas) {
        try {
            Entrada entrada = new Entrada(
                new Dinero(
                    caracteristicas.montoEntrada.toBigDecimal(), 
                    Moneda[caracteristicas.monedaEntrada]
                )
            )
        } catch (RuntimeException e) { 
            throw new RuntimeException("Valor de precio de entrada inválido")
        }

        Zona zona = zonaService.get(caracteristicas.zonaId)

        try {
            def capacidad = caracteristicas.capacidadMaxima.toInteger()
        } catch (RuntimeException e) {
            throw new RuntimeException("Valor de capacidad máxima del lugar inválido")
        }

        Lugar lugar = new Lugar(
            caracteristicas.nombre,
            caracteristicas.direccion,
            caracteristicas.descripcion,
            capacidad,
            entrada, 
            zona
        )

        caracteristicas.musicasId.each{ id ->  
            def musica = musicaService.get(id)
            lugar.addToMusica(musica)
        }

        caracteristicas.comidasId.each{ id ->  
            def comida = comidaService.get(id)
            lugar.addToComidas(comida)
        }

        caracteristicas.bebidasId.each{ id ->  
            def bebida = bebidaService.get(id)
            lugar.addToBebidas(bebida)
        }

        lugar
    }
}
