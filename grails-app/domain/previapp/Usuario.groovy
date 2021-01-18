package previapp

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import grails.gorm.dirty.checking.DirtyCheck

@DirtyCheck
@GrailsCompileStatic
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
    Date creacion
    Presupuesto presupuesto

    static hasMany = [visitas: Visita]
    static embedded = ['reputacion', 'persona', 'presupuesto']

    Usuario(String username, String password, Persona persona, Zona zona, Musica musicaFavorita, Presupuesto presupuesto) {
        this.username = username
        this.password = password
        this.reputacion = new Reputacion()
        this.persona = persona
        this.zona = zona
        this.musicaFavorita = musicaFavorita
        this.presupuesto = presupuesto
        this.creacion = new Date()
    }

    Set<Role> getAuthorities() {
        (UsuarioRole.findAllByUsuario(this) as List<UsuarioRole>)*.role as Set<Role>
    }

    static constraints = {
        username nullable: false, blank: false, unique: true
        password nullable: false, blank: false, password: true
        reputacion nullable: false
        zona nullable: false
        musicaFavorita nullable: true
        creacion nullable: false
        presupuesto nullable: true
    }

    static mapping = {
        table 'usuarios'
        username nullable: false, unique: true
	password column: '`password`'
        zona nullable: false
        musicaFavorita nullable: false
        creacion nullable: false
    }
}
