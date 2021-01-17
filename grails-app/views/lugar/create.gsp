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
            <g:hasErrors bean="${this.lugar}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.lugar}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.lugar}" method="POST">
                <f:field bean="lugar" property="nombre" name="nombre"/>
                <f:field bean="lugar" property="direccion" name="direccion"/>
                <f:field bean="lugar" property="descripcion" name="descripcion"/>
                <f:field bean="lugar" property="capacidadMaxima" name="capacidadMaxima" min="0"/>
                <f:field bean="lugar" property="entrada" name="entrada"/>
                <f:field bean="lugar" property="musica" name="musica"/>
                <f:field bean="lugar" property="comidas" name="comidas"/>
                <f:field bean="lugar" property="bebidas" name="bebidas"/>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
