package unam.diplomado.pokemon.pokemonservice.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Document(collection="entrenadores")
public class Entrenadores {
	
		@Id
		private String id;
		@NotBlank(message = "Nombre no puede estar vacío")
		private String nombre;
		private String edad;
	    private Set<String> pokemonesElegidos = new LinkedHashSet<>();


	}


