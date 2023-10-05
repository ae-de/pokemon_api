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
curl -X POST \
  http://localhost:8083/api/entrenadores \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "nombre": "Aristóteles",
    "edad": "22"
  }

## Resultado Esperado

Status: 200 OK

{
  "nombre": "Aristóteles",
  "edad": "22",
  "pokemonesElegidos": []
}

## Restricción
Sin embargo, no se permitirá registrar nuevamente a un entrenador con el mismo nombre y edad.
Si intentas registrar al mismo entrenador, obtendrás una respuesta con un código de estado 409 Conflict

Status 400 Conflict
{
  "message": "Entrenador ya registrado. No se pueden registrar entrenadores duplicados."
}

## Eliminar Entrenador

curl -X DELETE \
http://localhost:8083/api/entrenadores \
-H 'Content-Type: application/json' \
-d '{
  "nombre": "Arnulfo",
  "edad": "15"
}'

## Resultado Esperado

Status 200 OK
{
    "message": "Entrenador borrado con éxito."
}

