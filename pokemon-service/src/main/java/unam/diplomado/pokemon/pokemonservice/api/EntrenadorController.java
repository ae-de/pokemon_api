package unam.diplomado.pokemon.pokemonservice.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;
import unam.diplomado.pokemon.pokemonservice.repository.EntrenadoresRepository;

@RestController
@RequestMapping(path="entrenadores", produces="application/json")

public class EntrenadorController {

	@Autowired
	private EntrenadoresRepository entrenadoresRepository;

	

	@GetMapping
	public Iterable<Entrenadores> obtenerEntrenadores() {
	    return entrenadoresRepository.findAll();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Entrenadores crearEntrenador(@RequestBody Entrenadores entrenador) {
	    return entrenadoresRepository.save(entrenador);
	}

	@GetMapping("{id}")
	public ResponseEntity<Entrenadores> obtenerEntrenadorPorId(@PathVariable("id") String id) {
	    Optional<Entrenadores> entrenador = entrenadoresRepository.findById(id);
	    if (entrenador.isPresent()) {
	        return new ResponseEntity<>(entrenador.get(), HttpStatus.OK);
	    }
	    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	}
