package unam.diplomado.pokemon.pokemonservice.domain;

public class PokemonNotFoundException extends RuntimeException {

    public PokemonNotFoundException(String message) {
        super(message);
    }
}