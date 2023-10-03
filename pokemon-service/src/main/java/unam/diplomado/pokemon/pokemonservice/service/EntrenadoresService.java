package unam.diplomado.pokemon.pokemonservice.service;

import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;

public interface EntrenadoresService {
    Entrenadores actualizarEntrenador(String id, Entrenadores entrenador);

    Entrenadores elegirPokemon(String entrenadorId, String pokemonId); 

    Entrenadores retirarPokemon(String entrenadorId, String pokemonId);
}
