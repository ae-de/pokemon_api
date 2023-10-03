package unam.diplomado.pokemon.pokemonservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pokemon.pokemonservice.domain.EntrenadorNotFoundException;
import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;
import unam.diplomado.pokemon.pokemonservice.domain.MaximoPokemonesException;
import unam.diplomado.pokemon.pokemonservice.domain.Pokemon;
import unam.diplomado.pokemon.pokemonservice.domain.PokemonDuplicadoException;
import unam.diplomado.pokemon.pokemonservice.domain.PokemonNotFoundException;
import unam.diplomado.pokemon.pokemonservice.repository.EntrenadoresRepository;
import unam.diplomado.pokemon.pokemonservice.repository.PokemonRepository;

@Service
public class EntrenadoresServiceImpl implements EntrenadoresService {

    @Autowired
    private EntrenadoresRepository entrenadoresRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    // Método para que un entrenador elija un Pokémon.
    public Entrenadores elegirPokemon(String entrenadorId, String pokemonId) {
        Entrenadores entrenador = entrenadoresRepository.findById(entrenadorId)
                .orElseThrow(() -> new EntrenadorNotFoundException("Entrenador no encontrado"));

        if (entrenador.getPokemonesElegidos().size() >= 6) {
            throw new MaximoPokemonesException("El entrenador ya ha elegido el máximo de Pokémon permitidos.");
        }

        if (entrenador.getPokemonesElegidos().contains(pokemonId)) {
            throw new PokemonDuplicadoException("El entrenador ya ha elegido este Pokémon.");
        }

        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon no encontrado"));

        entrenador.getPokemonesElegidos().add(pokemonId);
        entrenadoresRepository.save(entrenador);

        return entrenador;
    }

    // Método para que un entrenador retire un Pokémon elegido.
    public Entrenadores retirarPokemon(String entrenadorId, String pokemonId) {
        Entrenadores entrenador = entrenadoresRepository.findById(entrenadorId)
                .orElseThrow(() -> new EntrenadorNotFoundException("Entrenador no encontrado"));

        if (!entrenador.getPokemonesElegidos().contains(pokemonId)) {
            throw new PokemonNotFoundException("El Pokémon no está en la lista de los elegidos por el entrenador.");
        }

        entrenador.getPokemonesElegidos().remove(pokemonId);
        entrenadoresRepository.save(entrenador);

        return entrenador;
    }

    public List<Entrenadores> obtenerTodosLosEntrenadores() {
        return entrenadoresRepository.findAll();
    }

	@Override
	public Entrenadores actualizarEntrenador(String id, Entrenadores entrenador) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}

