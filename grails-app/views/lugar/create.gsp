<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lugar.label', default: 'Lugar')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-lugar" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-lugar" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">                
            <div class="message" role="status">${flash.message}</div>
            </g:if>                                       
            <g:hasErrors bean="${lugarForm}">            
                <ul class="errors" role="alert">          
                    <g:eachError bean="${lugarForm}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>                        
                </ul>
            </g:hasErrors>
            <g:if test="${errorMsg}">
                <ul class="errors" role="alert">          
                   <li>${errorMsg}</li>
                </ul>
            </g:if>
            <g:form resource="lugar" method="POST">
                <f:field bean="${lugarForm}" property="nombre" name="nombre"/>
                <f:field bean="${lugarForm}" property="direccion" name="direccion"/>
                <f:field bean="${lugarForm}" property="descripcion" name="descripcion"/>
                <f:field bean="${lugarForm}" property="capacidadMaxima" name="capacidadMaxima" min="0"/>
                <f:field bean="${lugarForm}" property="monedaEntrada" name="monedaEntrada"/>
                <f:field bean="${lugarForm}" property="valorEntrada" name="valorEntrada"/>
                <div style="margin: 50px;">
                    <h2> Seleccioná la zona de tu establecimiento </h2>
                    <hr class="solid">
                    <label for="zona">Zona</label>
                    <select name="zonaId" id="zona">
                        <g:each var="zona" in="${zonas}">
                            <option value="${zona.id}" selected="selected">${zona.nombre}</option>
                        </g:each>
                    </select>
                </div>
                <div style="margin: 50px;">
                    <h2> Seleccioná la comida que tiene tu establecimiento </h2>
                    <hr class="solid">
                    <g:each var="comida" in="${comidas}">
                        <label for="comidaSeleccionada">${comida.nombre}</label>
                        <g:checkBox checked="false" value="${comida.id}" id="comidaSeleccionada" name="comidasId"/>
                        </br>
                    </g:each>
                </div>
                <div style="margin: 50px;">
                    <h2> Seleccioná la bebida que tiene tu establecimiento </h2>
                    <hr class="solid">
                    <g:each var="bebida" in="${bebidas}">
                        <label for="bebidaSeleccionada">${bebida.nombre}</label>
                        <g:checkBox value="${bebida.id}" id="bebidaSeleccionada" name="bebidasId"/>
                        </br>
                    </g:each>
                </div>
                <div style="margin: 50px;">
                    <h3> Seleccioná la música que se escucha en tu establecimiento </h2>
                    <hr class="solid">
                    <g:each var="musica" in="${generosMusicales}">
                        <label for="musicaSeleccionada">${musica.generoMusical}</label>
                        <g:checkBox value="${musica.id}" id="musicaSeleccionada" name="musicasId"/>
                        </br>
                    </g:each>
                </div>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
