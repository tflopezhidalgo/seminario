<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Mi perfil</title>
    </head>
    <body>
        <a href="#show-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="test" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <asset:image src="test.jpg" alt="User" style="width: 150px; margin: 30px;"/>
            <br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Nombre de usuario: </label> 
            <f:display bean="currentUser" property="username"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Reputacion: </label> 
            <f:display bean="currentUser" property="reputacion.puntos"/><br>
            <f:display bean="currentUser" property="reputacion.rango"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Tu presupuesto es: </label> 
            <f:display bean="currentUser" property="presupuesto.monto"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Tu musica favorita es: </label> 
            <f:display bean="currentUser" property="musicaFavorita"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Tu comida favorita es: </label> 
            <f:display bean="currentUser" property="comidaFavorita"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Tu bebida favorita es: </label> 
            <f:display bean="currentUser" property="bebidaFavorita"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Datos personales</label> 
            <br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Nombre: </label> 
            <f:display bean="currentUser" property="persona.nombre"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Apellido: </label> 
            <f:display bean="currentUser" property="persona.apellido"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Edad: </label> 
            <f:display bean="currentUser" property="persona.edad"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Zona de residencia: </label> 
            <f:display bean="currentUser" property="zona"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Lugares que visitaste: </label> 
            <f:display bean="currentUser" property="visitas"/><br>


            <g:form resource="${this.usuario}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
