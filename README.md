# Framework basado en Selenium - Cucumber - Java

## Descripción

Se trata de un Framework de automatización basado en Selenium, utilizando cucumber y Java como lenguaje de programación. Al realizar este proyecto, aún en desarrollo, se intenta poner en practica lo aprendido en diversos cursos al respecto y seguir aprendiendo.

## Ejecutar

1.  Descargar el projecto y ejecutar
     * mvn install -DskipTests
2. Este proyecto utiliza WebdriverManager version 5.3.0 de bonigarcia y en esta versión se puede utilizar:
    * CHROME
    * FIREFOX
    * REMOTE_CHROME (Selenium Grid - Chrome)
3. Ejemplo para ejecutar una prueba con Chrome de forma local:
***mvn verify -DdriverName=CHROME***
3. Ejemplo para ejecutar una prueba con Chrome de forma local:
**mvn verify -DdriverName=FIREFOX** *(en este momento la configuración de Firefox esta en --headless esto se puede modificar en el archivo de configuración global.properties en la clave browser.firefox.confi)* 
4. Para probar con Selenium Grid deberemos tener corriendo docker, posicionar en la carpeta raiz de nuestro proyecto y ejecutar: 
    * **docker build -t samplemaven:latest .**
    * **docker-compose -f docker-compose-yml up -d**
    * **mvn verify -DdriverName=REMOTE_CHROME -DREMOTE_IP=localhost**
    
## Reportes

Al ejecutar los casos de pruebas, se generará, en la carpeta test-output un archivo *ExtentHtml.html*. Al abrirlo veremos un reporte de los casos ejecutados. Se trata del reporte extendido ofrecido de Cucumber.

## Próximas versiones
* Poder utilizar Firefox en Selenium Grid
* Incorporar CI/DI (en progreso)
* Poder ejecutar las pruebas desde un container docker (en progreso)
