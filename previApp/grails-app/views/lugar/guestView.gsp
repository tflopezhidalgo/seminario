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
            <label style="font-weight: bold; font-size: 30">Nombre: </label> <f:display bean="lugar" property="nombre"/><br>
            <label style="font-weight: bold; font-size: 30">Dirección: </label> <f:display bean="lugar" property="direccion"/><br>
            <label style="font-weight: bold; font-size: 30">Descripción: </label> <f:display bean="lugar" property="descripcion"/><br>
            <label style="font-weight: bold; font-size: 30">Puntuación: </label> <f:display bean="lugar" property="puntuacion"/><br>
            <label style="font-weight: bold; font-size: 30">Entrada: </label> <f:display bean="lugar" property="entrada"/><br>
            <label style="font-weight: bold; font-size: 30">Capacidad máxima: </label> <f:display bean="lugar" property="capacidadMaxima"/><br>
            <label style="font-weight: bold; font-size: 30">Visitas recibidas: </label> <f:display bean="lugar" property="visitas"/><br>
        </div>
    </body>
</html>
