package previapp

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.gorm.dirty.checking.DirtyCheck

@DirtyCheck
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Reputacion reputacion

    Persona persona

    Zona zona
    Musica musicaFavorita
    Comida comidaFavorita
    Bebida bebidaFavorita
    Date creacion
    Presupuesto presupuesto

    static hasMany = [visitas: Visita]
    static embedded = ['reputacion', 'persona', 'presupuesto']

    static constraints = {
        username nullable: false, blank: false, unique: true
        password nullable: false, blank: false, password: true
        reputacion nullable: false
        zona nullable: false
        musicaFavorita nullable: true
        comidaFavorita nullable: true
        bebidaFavorita nullable: true
        creacion nullable: false
        presupuesto nullable: true
    }

    static mapping = {
        table 'usuarios'
        username nullable: false, unique: true
	    password column: '`password`'
        zona nullable: false
        musicaFavorita nullable: false
        bebidaFavorita nullable: true
        comidaFavorita nullable: true
        creacion nullable: false
    }

    Usuario(String username, String password, Persona persona, Zona zona, Musica musicaFavorita, Presupuesto presupuesto) {
        this.username = this.validarUsername(username)
        this.password = password
        this.reputacion = new Reputacion()
        this.persona = persona
        this.zona = zona
        this.musicaFavorita = musicaFavorita
        this.presupuesto = presupuesto
        this.creacion = new Date()
    }

    private String validarUsername(String username) {
        if(!username)
            throw new UsuarioInvalidoError("No se puede crear un usuario sin nombre")
        username
    }

    Set<Role> getAuthorities() {
        (UsuarioRole.findAllByUsuario(this) as List<UsuarioRole>)*.role as Set<Role>
    }

    Boolean esUsuarioOro() {
        this.reputacion.esOro()
    }

    Integer calcularAfinidadConLugar(Lugar lugar) {
        /* Calcula la afinidad entre un Lugar y this */

        def calcularPromedioLista = { l -> (l.sum() / l.size) }

        def promediablesAfinidad = []

        if (this.musicaFavorita && lugar.musica) {
            def similitudesUsuarioLugarMusica = lugar.musica.collect { musica ->
                musica.calcularSimilitud(this.musicaFavorita)
           }

           promediablesAfinidad << calcularPromedioLista(similitudesUsuarioLugarMusica)
        }

        if (this.bebidaFavorita && lugar.bebidas) {
            def similitudesUsuarioLugarBebidas = lugar.bebidas.collect { bebida ->
                bebida.calcularSimilitud(this.bebidaFavorita)
           }

           promediablesAfinidad << calcularPromedioLista(similitudesUsuarioLugarBebidas)
        }

        if (this.comidaFavorita && lugar.comidas) {
            def similitudesUsuarioLugarComidas = lugar.comidas.collect { comida->
                comida.calcularSimilitud(this.comidaFavorita)
           }

           promediablesAfinidad << calcularPromedioLista(similitudesUsuarioLugarComidas)
        }

        if (promediablesAfinidad.size) {
            return calcularPromedioLista(promediablesAfinidad)
        }

        0
    }
}
