package unam.diplomado.pokemon.pokemonservice.service;

import java.util.List;

import unam.diplomado.pokemon.pokemonservice.domain.Pokemon;

public interface PokemonService {
    Pokemon obtenerPokemonPorId(String pokemonId);
    List<Pokemon> obtenerTodosLosPokemones();
    List<Pokemon> buscarPokemonesPorNombre(String nombre);
    
}
