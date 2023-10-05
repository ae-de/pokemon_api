package unam.diplomado.pokemon.pokemonservice.domain;

public class EntrenadorYaRegistradoException extends RuntimeException {

    public EntrenadorYaRegistradoException(String message) {
        super(message);
    }

    public EntrenadorYaRegistradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
