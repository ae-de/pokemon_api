# pokemon_api

## Project

Este microservicio se encarga de administrar a los entrenadores de Pokémon. 
Proporciona endpoints para:
 - Registrar entrenador
 - Eliminar entrenadores
 - No permitir nuevamente registrar un entrenador previamente  basado en su nombre y edad.

## Deploy

//TODO.

## Test

Puedes realizar pruebas en este microservicio utilizando herramientas como `curl`. Aquí hay un ejemplo de cómo registrar un nuevo entrenador:

```bash
curl -X POST \
  http://localhost:8083/api/entrenadores \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "nombre": "Aristóteles",
    "edad": "22"
  }

  

## Expected Result

{
  "nombre": "Aristóteles",
  "edad": "22",
  "pokemonesElegidos": []
}

## Restricción
Sin embargo, no se permitirá registrar nuevamente a un entrenador con el mismo nombre y edad.
Si intentas registrar al mismo entrenador, obtendrás una respuesta con un código de estado 409 Conflict

{
  "message": "Entrenador ya registrado. No se pueden registrar entrenadores duplicados."
}



