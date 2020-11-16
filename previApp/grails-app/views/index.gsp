<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Previapp</title>
    </head>
    <body>
        <content tag="nav">
            <li class="dropdown">
                <a href="/profile"> Mi perfil <span class="caret"></span> </a>
            </li>
            <li class="dropdown">
                <a href="/logout" style="justify-content: center;" role="button" aria-haspopup="true" > Cerrar sesión </a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Controllers <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller dropdown-item">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </li>
        </content>
        <div class="svg" role="presentation">
            <div class="grails-logo-container">
            </div>
        </div>
        <div id="content" role="main" >
            <section class="row colset-12-its">
                <h1>Bienvenido a PreviApp</h1>
                <g:each in="${recomendaciones}" var="recomendacion">
                    <div class="card">
                        <div class="card-body">
                            <asset:image src="place.png" alt="Previapp Logo" style="width: 100px;"/>
                            <p><b>Lugar</b>: ${recomendacion.lugar}</p>
                            <p><b>Zona</b>: ${recomendacion.lugar.zona} </p>
                            <p><b>Capacidad Máxima</b>: ${recomendacion.lugar.capacidadMaxima} </p>
                            <p><b>Precio entrada</b>: ${recomendacion.lugar.entrada} </p>
                            <p><b>Descripcion</b>: Birra gratis</p>
                            <p><b>Puntaje</b>: ${recomendacion.puntaje}</p>
                            <div style="align-items:center; justify-content:center; ">
                                <g:form url="[controller: 'visita', action: 'create', id: recomendacion.lugar.id]" method="POST"> 
                                    <input type="submit" value="Agregar visita"/> 
                                </g:form>
                            </div>
                        </div>
                    </div>
                </g:each>
                <input type="button" value="Actualizar" class="button"/> 
            </section>
        </div>
    </body>
</html>
