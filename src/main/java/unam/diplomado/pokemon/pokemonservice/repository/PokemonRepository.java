package unam.diplomado.pokemon.pokemonservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pokemon.pokemonservice.domain.Pokemon;

public interface PokemonRepository 
extends MongoRepository<Pokemon, String> {
    List<Pokemon> findByNombre(String nombre);
    List<Pokemon> findByTipo(String tipo);

}
