package unam.diplomado.pokemon.pokemonservice.service;

import java.util.List;

import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;

public interface EntrenadoresService {
    Entrenadores elegirPokemon(String entrenadorId, String pokemonId);
    Entrenadores retirarPokemon(String entrenadorId, String pokemonId);
    List<Entrenadores> obtenerTodosLosEntrenadores();
    List<String> obtenerPokemonesElegidos(String entrenadorId);
	Entrenadores registrarEntrenador(Entrenadores entrenador);
	List<Entrenadores> findByNombreAndEdad(String nombre, String edad);

	
	void eliminarEntrenador(String nombre, String edad);

	
}
