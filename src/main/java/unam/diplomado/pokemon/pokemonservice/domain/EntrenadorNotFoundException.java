package unam.diplomado.pokemon.pokemonservice.domain;

public class EntrenadorNotFoundException extends RuntimeException {
    public EntrenadorNotFoundException(String message) {
        super(message);
    }
}
