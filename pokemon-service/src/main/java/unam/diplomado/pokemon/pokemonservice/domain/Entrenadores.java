package unam.diplomado.pokemon.pokemonservice.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="entrenadores")
public class Entrenadores {
	
		@Id
		private String id;
		private String nombre;
	    private Set<String> pokemonesElegidos = new HashSet<>();


	}


