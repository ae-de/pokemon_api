package unam.diplomado.pokemon.pokemonservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pokemones")
public class Pokemon {
    @Id
    private String id;
    private String nombre;
    private String tipo; 
}
