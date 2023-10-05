package unam.diplomado.pokemon.pokemonservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ErrorMessage {
    private String message;

    @Getter
    @Setter
    public static class EntrenadorRequest {
        private String nombre;
        private String edad;
    }

    public ErrorMessage(String message) {
        this.message = message;
    }
}
