package previapp

import grails.gorm.services.Service

@Service(Lugar)
abstract class LugarService {

    ZonaService zonaService
    MusicaService musicaService
    ComidaService comidaService
    BebidaService bebidaService

    abstract Lugar get(Serializable id)

    abstract List<Lugar> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Lugar save(Lugar lugar)

    Lugar crearLugar(Map data) {
        Entrada entrada = new Entrada(new Dinero(data.montoEntrada, data.monedaEntrada))
        Zona zona = zonaService.get(data.zonaId)
        Lugar lugar = new Lugar(data.nombre, data.direccion, data.descripcion, data.capacidadMaxima, entrada, zona)

        musicaService.obtenerMusica(data.musicasId).each { musica -> lugar.addToMusica(musica) }
        comidaService.obtenerComidas(data.comidasId).each { comida -> lugar.addToComidas(comida) }
        bebidaService.obtenerBebidas(data.bebidasId).each { bebida -> lugar.addToBebidas(bebida) }

        lugar
    }
}
