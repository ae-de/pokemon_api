package unam.diplomado.pokemon.pokemonservice.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pokemon.pokemonservice.domain.Pokemon;
import unam.diplomado.pokemon.pokemonservice.repository.PokemonRepository;

@RestController
@RequestMapping(value = "/pokemones", produces = "application/json")
@CrossOrigin(origins = "*")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping
    public Iterable<Pokemon> obtenerPokemones() {
        return pokemonRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Pokemon> obtenerPokemonPorId(@PathVariable("id") String id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if (pokemon.isPresent()) {
            return new ResponseEntity<>(pokemon.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
