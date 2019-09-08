# taller-3-Arep
# clientes y servicios
#### esta es una clase el cual se encarga de un manejo basico de objetos url y sockects para la imprementacion de servidores y clientes, y el manejo de distintos paquetes entre ellos htmls, imagenes etc

# Prerequisitos
```
mvn 3.6 Guia-->https://www.youtube.com/watch?v=biBOXvSNaXg
java 1.8 Guia -->https://www.youtube.com/watch?v=kPWezAZGPks
```
#
# Instalacion y ejecucion del proyecto

## local


1. Descargue el repositorio
```
git clone https://github.com/ItaloNovoa/ProyectoAREM
```
2. ingrese por cmd, terminal o simbolo del sistema a la ubicacion del documento
3. digite la siguiente lineas para descargar dependencias
```
mvn package
mvn install
```
4. ejecutar proyecto
- ejercicio1
```
 mvn exec:java -D exec.mainClass="edu.eci.taller3.Ejercicio1"
```
- ejercicio2
```
 mvn exec:java -D exec.mainClass="edu.eci.taller3.Ejercicio2"
```
- ejercicio3
```
 mvn exec:java -D exec.mainClass="edu.eci.taller3.Ejercicio3ClienteCuadrado"
 mvn exec:java -D exec.mainClass="du.eci.taller3.Ejercicio3ServidorCuadrado"
```
- ejercicio4 (url de ejemplo "http://localhost:35000/2asd.png y http://localhost:35000/resultado.html")
```
 mvn exec:java -D exec.mainClass="edu.eci.taller3.Ejercicio4_5_1"
```
- ejercicio5
```
 mvn exec:java -D exec.mainClass="edu.eci.taller3.DatagramTimeClient"
 mvn exec:java -D exec.mainClass="du.eci.taller3.DatagramTimeServer"
```

# Ejecutar Pruebas
```
mvn test
```
