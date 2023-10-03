package unam.diplomado.pokemon.pokemonservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;

public interface EntrenadoresRepository 
	extends MongoRepository<Entrenadores, String>{

}
