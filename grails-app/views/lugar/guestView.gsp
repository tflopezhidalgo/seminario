<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lugar.label', default: 'Lugar')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-lugar" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="show-lugar" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>

            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Nombre: </label> 
            <f:display bean="lugar" property="nombre"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Dirección: </label> 
            <f:display bean="lugar" property="direccion"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Puntuación: </label> 
            ${this.lugar.puntuacion} <br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Entrada: </label> 
            ${this.lugar.entrada} <br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Capacidad máxima: </label> 
            <f:display bean="lugar" property="capacidadMaxima"/><br>

            <label style="font-weight: bold; font-size: 15px;">Música: </label> 
            <f:display bean="lugar" property="musica"/><br>

            <label style="font-weight: bold; font-size: 15px;">Comida: </label> 
            <f:display bean="lugar" property="comidas"/><br>

            <label style="font-weight: bold; font-size: 15px;">Bebida: </label> 
            <f:display bean="lugar" property="bebidas"/><br>

            <label style="font-weight: bold; font-size: 15px; margin: 6px">Descripción: </label> 
            <f:display bean="lugar" property="descripcion"/><br>

            <div style="padding: 30px">
                <label style="font-weight: bold; font-size: 18px">Visitas más influyentes</label> 

                <table style="margin: 30px">
                    <tr>
                        <th>Fecha de visita </th>
                        <th>Usuario</th>
                        <th>Comentario </th>
                        <th>Puntuación </th>
                    </tr>
                    <g:each in="${visitasOro}" var="visita">
                        <tr>
                            <td> ${visita.fecha} </td>
                            <td> ${visita.usuario.username} </td>
                            <td> ${visita.comentario} </td>
                            <td> ${visita.puntuacion} </td>
                        </tr>
                    </g:each>
                </table>

                <label style="font-weight: bold; font-size: 18px">Visitas</label> 

                <table style="margin: 30px">
                    <tr>
                        <th>Fecha de visita </th>
                        <th>Usuario</th>
                        <th>Comentario </th>
                        <th>Puntuación </th>
                    </tr>
                    <g:each in="${visitasNoOro}" var="visita">
                        <tr>
                            <td> ${visita.fecha} </td>
                            <td> ${visita.usuario.username} </td>
                            <td> ${visita.comentario} </td>
                            <td> ${visita.puntuacion} </td>
                        </tr>
                    </g:each>
                </table>
            </div>
        </div>
    </body>
</html>
