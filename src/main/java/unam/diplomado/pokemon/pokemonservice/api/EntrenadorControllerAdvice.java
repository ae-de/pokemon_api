package unam.diplomado.pokemon.pokemonservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import unam.diplomado.pokemon.pokemonservice.domain.EntrenadorYaRegistradoException;
import unam.diplomado.pokemon.pokemonservice.domain.MaximoPokemonesException;
import unam.diplomado.pokemon.pokemonservice.domain.PokemonDuplicadoException;
import unam.diplomado.pokemon.pokemonservice.domain.PokemonNotFoundException;

@ControllerAdvice
public class EntrenadorControllerAdvice {

    
    @ExceptionHandler(MaximoPokemonesException.class)
    public ResponseEntity<Object> handleMaximoPokemonesException(
            MaximoPokemonesException ex, WebRequest request) {
        String errorMessage = "El entrenador ya ha elegido el máximo de Pokémon permitidos.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(PokemonDuplicadoException.class)
    public ResponseEntity<Object> handlePokemonDuplicadoException(
            PokemonDuplicadoException ex, WebRequest request) {
        String errorMessage = "El entrenador ya ha elegido este Pokémon.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<Object> handlePokemonNotFoundException(
            PokemonNotFoundException ex, WebRequest request) {
        String errorMessage = "Pokemon no encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(EntrenadorYaRegistradoException.class)
    public ResponseEntity<Object> handleEntrenadorYaRegistradoException(
            EntrenadorYaRegistradoException ex, WebRequest request) {
        String errorMessage = "El entrenador ya está registrado.";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    }
