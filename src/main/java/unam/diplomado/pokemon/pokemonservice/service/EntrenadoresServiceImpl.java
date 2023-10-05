package unam.diplomado.pokemon.pokemonservice.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pokemon.pokemonservice.domain.EntrenadorNotFoundException;
import unam.diplomado.pokemon.pokemonservice.domain.EntrenadorYaRegistradoException;
import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;
import unam.diplomado.pokemon.pokemonservice.domain.MaximoPokemonesException;
import unam.diplomado.pokemon.pokemonservice.domain.PokemonDuplicadoException;
import unam.diplomado.pokemon.pokemonservice.repository.EntrenadoresRepository;
import unam.diplomado.pokemon.pokemonservice.repository.PokemonRepository;

@Service
public class EntrenadoresServiceImpl implements EntrenadoresService {

    @Autowired
    private EntrenadoresRepository entrenadoresRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public Entrenadores registrarEntrenador(Entrenadores entrenador) {
        Entrenadores entrenadorExistente = entrenadoresRepository.findByNombreAndEdad(
                entrenador.getNombre(), entrenador.getEdad());
        if (entrenadorExistente != null) {
            throw new EntrenadorYaRegistradoException("Entrenador ya registrado");
        }
        return entrenadoresRepository.save(entrenador);
    }


    @Override
    public Entrenadores elegirPokemon(String entrenadorId, String pokemonId) {
    	Entrenadores entrenador = entrenadoresRepository.findById(entrenadorId).orElse(new Entrenadores());

        if (entrenador.getPokemonesElegidos().size() >= 6) {
            throw new MaximoPokemonesException("El entrenador ya ha elegido el máximo de Pokémon permitidos.");
        }

        if (entrenador.getPokemonesElegidos().contains(pokemonId)) {
            throw new PokemonDuplicadoException("El entrenador ya ha elegido este Pokémon.");
        }

        entrenador.getPokemonesElegidos().add(pokemonId);
        entrenadoresRepository.save(entrenador);

        return entrenador;
    }
    
    @Override
    public List<String> obtenerPokemonesElegidos(String entrenadorId) {
        Entrenadores entrenador = entrenadoresRepository.findById(entrenadorId)
                .orElseThrow(() -> new EntrenadorNotFoundException("Entrenador no encontrado"));
        List<String> pokemonesElegidos = new ArrayList<>(entrenador.getPokemonesElegidos());

        return pokemonesElegidos;
    }

    @Override
    public void eliminarEntrenador(String nombre, String edad) {
        entrenadoresRepository.deleteByNombreAndEdad(nombre, edad);
    }


   @Override
	public List<Entrenadores> obtenerTodosLosEntrenadores() {
		// TODO Auto-generated method stub
		return null;
	}


@Override
public Entrenadores retirarPokemon(String entrenadorId, String pokemonId) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<Entrenadores> findByNombreAndEdad(String nombre, String edad) {
	// TODO Auto-generated method stub
	return null;
}


	}
