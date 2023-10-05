# pokemon_api

## Project

Este microservicio se encarga de administrar a los entrenadores de Pokémon. 

Se crearon notificaciones para: 

 - Registrar entrenador
    
 - No permitir agregar nuevamente a un entrenador ya registrado.

 - - Eliminar entrenadores

## Deploy

//TODO.

## Test

Ejecute los siguientes comandos `curl` para validar el deploy del servicio.

 #Registrar Usuario
```bash
curl -X 'POST' \
 ' http://localhost:8083/api/entrenadores \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "nombre": "Aristóteles",
    "edad": "22"
  }'

'## Resultado Esperado

Status: 200 OK

{
  "nombre": "Aristóteles",
  "edad": "22",
  "pokemonesElegidos": []
}'

'## Restricción
Sin embargo, no se permitirá registrar nuevamente a un entrenador con el mismo nombre y edad.
Si intentas registrar al mismo entrenador, obtendrás una respuesta con un código de estado 409 Conflict

Status 400 Conflict
{
  "message": "Entrenador ya registrado. No se pueden registrar entrenadores duplicados."
}'

## Eliminar Entrenador

curl -X DELETE \
http://localhost:8083/api/entrenadores \
-H 'Content-Type: application/json' \
-d '{
  "nombre": "Arnulfo",
  "edad": "15"
}'
```bash
## Resultado Esperado

Status 200 OK
{
    "message": "Entrenador borrado con éxito."
}
```bash
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#web)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#data.nosql.mongodb)
