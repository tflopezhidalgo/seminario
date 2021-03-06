<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title> Edición de usuario</title>
    </head>
    <body>
        <a href="#edit-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-usuario" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.usuario}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.usuario}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="update" controller="profile" method="PUT">
                <g:hiddenField name="version" value="${this.usuario?.version}" />

                <f:with bean="${this.usuario}" >  
                    <f:with prefix="persona." bean="${this.usuario.persona}">
                        <f:field property="nombre"/>
                        <f:field property="apellido"/>
                        <f:field property="edad"/>
                    </f:with>
                    <f:field property="zona"/>
                    <f:field property="musicaFavorita"/>
                    <f:field property="comidaFavorita"/>
                    <f:field property="bebidaFavorita"/>
                    <f:with bean="${this.usuario.presupuesto}"> 
                        <f:with prefix="presupuesto.monto." bean="${this.usuario.presupuesto.monto}">
                            <f:field property="monto"/>
                            <f:field property="moneda"/>
                        </f:with>
                    </f:with>
                </f:with>

                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
