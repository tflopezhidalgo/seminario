# seminario

# Problemas frecuentes:

Al intentar correr ```grails``` sobre el directorio me sale el siguiente mensaje: _Gradle build daemon disappeared unexpectedly grails_
- Se soluciona con ```rm -r ~/.gradle
Este error se produce debido a la baja memoria que se le asigna por defecto a java, en particular al framework de gradle

# How to deploy

Para correr la app

``` 
cd $PATH_TO_REPO
grails run-app
```

