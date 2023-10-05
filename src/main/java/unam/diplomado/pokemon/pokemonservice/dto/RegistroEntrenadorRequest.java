package unam.diplomado.pokemon.pokemonservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;

@Data
@NoArgsConstructor
public class RegistroEntrenadorRequest {
	
	@NotNull
	@Valid
	private Entrenadores entrenador;
}
