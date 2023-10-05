package unam.diplomado.pokemon.pokemonservice.domain;

public class PokemonDuplicadoException extends RuntimeException {

    public PokemonDuplicadoException(String message) {
        super(message);
    }
}