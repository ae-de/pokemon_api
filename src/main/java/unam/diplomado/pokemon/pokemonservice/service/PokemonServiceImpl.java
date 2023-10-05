package unam.diplomado.pokemon.pokemonservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pokemon.pokemonservice.domain.Pokemon;
import unam.diplomado.pokemon.pokemonservice.domain.PokemonNotFoundException;
import unam.diplomado.pokemon.pokemonservice.repository.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public Pokemon obtenerPokemonPorId(String pokemonId) {
        return pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon no encontrado"));
    }

    @Override
    public List<Pokemon> obtenerTodosLosPokemones() {
        return pokemonRepository.findAll();
    }

    @Override
    public List<Pokemon> buscarPokemonesPorNombre(String nombre) {
        return pokemonRepository.findByNombre(nombre);
    }

    @Override
    public List<Pokemon> buscarPokemonesPorTipo(String tipo) {
        return pokemonRepository.findByTipo(tipo);
    }
}
