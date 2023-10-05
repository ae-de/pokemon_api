package unam.diplomado.pokemon.pokemonservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pokemon.pokemonservice.domain.EntrenadorNotFoundException;
import unam.diplomado.pokemon.pokemonservice.domain.EntrenadorYaRegistradoException;
import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;
import unam.diplomado.pokemon.pokemonservice.domain.ErrorMessage;
import unam.diplomado.pokemon.pokemonservice.domain.ErrorMessage.EntrenadorRequest;
import unam.diplomado.pokemon.pokemonservice.repository.EntrenadoresRepository;
import unam.diplomado.pokemon.pokemonservice.service.EntrenadoresService;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadoresService entrenadoresService;
    @Autowired
    private EntrenadoresRepository entrenadoresRepository;
    
    @GetMapping
    public List<Entrenadores> obtenerTodosLosEntrenadores() {
        return entrenadoresRepository.findAll();
    }


    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> registrarEntrenador(@RequestBody Entrenadores entrenador) {
        try {
            Entrenadores nuevoEntrenador = entrenadoresService.registrarEntrenador(entrenador);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEntrenador);
        } catch (EntrenadorYaRegistradoException e) {
            ErrorMessage errorMessage = new ErrorMessage("Entrenador ya registrado. No se pueden registrar entrenadores duplicados.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }
    }	
    		
    @DeleteMapping(consumes = "application/json")
    public ResponseEntity<ErrorMessage> eliminarEntrenador(@RequestBody EntrenadorRequest request) {
        String nombre = request.getNombre();
        String edad = request.getEdad();
        
        try {
            entrenadoresService.eliminarEntrenador(nombre, edad);
            ErrorMessage errorMessage = new ErrorMessage("Entrenador borrado con éxito.");
            return ResponseEntity.ok(errorMessage);
        } catch (EntrenadorNotFoundException e) {
            ErrorMessage errorMessage = new ErrorMessage("Entrenador no encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }



    
    
    



    
    
    // Otros métodos del controlador para elegir Pokémon, 
    //retirar Pokémon, obtener todos los entrenadores, etc.
}
