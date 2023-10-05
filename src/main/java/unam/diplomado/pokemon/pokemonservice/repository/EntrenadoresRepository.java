package unam.diplomado.pokemon.pokemonservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;

import java.util.List;

@Repository
public interface EntrenadoresRepository 
		extends MongoRepository<Entrenadores, String> {
    Entrenadores findByNombreAndEdad(String nombre, String edad);
    List<Entrenadores> findAllByNombreAndEdad(String nombre, String edad);
    void deleteByNombreAndEdad(String nombre, String edad);

}
