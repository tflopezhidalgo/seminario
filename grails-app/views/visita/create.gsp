<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'visita.label', default: 'Visita')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-visita" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-visita" class="content scaffold-create" role="main">
            <h1><g:message message="Crear visita en  ${this.visita.getLugar()}"/></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.visita}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.visita}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="visita" method="POST">
                <fieldset class="form">
                    <g:hiddenField name="lugar.id" value="${this.visita.getLugar().id}"/>
                    <f:field bean="${this.visita}" label="Fecha de visita" property="fecha"/>
                    <f:field bean="${this.visita}" property="comentario"/>
                    <f:field bean="${this.visita}" property="puntuacion"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
