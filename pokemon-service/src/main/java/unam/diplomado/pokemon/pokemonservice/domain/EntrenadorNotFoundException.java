package unam.diplomado.pokemon.pokemonservice.domain;

public class EntrenadorNotFoundException extends RuntimeException {

    public EntrenadorNotFoundException(String entrenadores) {
        super( "El entrenador ya ha sido registrado" + entrenadores);
    }
}
