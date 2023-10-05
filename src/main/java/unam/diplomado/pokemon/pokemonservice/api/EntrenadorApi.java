package unam.diplomado.pokemon.pokemonservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import unam.diplomado.pokemon.pokemonservice.domain.Entrenadores;
import unam.diplomado.pokemon.pokemonservice.dto.RegistroEntrenadorRequest;

@RequestMapping(path = "api/entrenadores", produces = "application/json")
@CrossOrigin(origins = "*")
@Tag(name = "entrenador", description = "API del Recurso Entrenador")
public interface EntrenadorApi {
    @Operation(summary = "Registrar Entrenador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Entrenador Creado Exitosamente", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Entrenadores.class))
        }),
        @ApiResponse(responseCode = "409", description = "Ya existe un entrenador con el nombre especificado", content = @Content)
    })
    @PostMapping(path = "registro", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    Entrenadores registrarEntrenador(@NotNull @Valid @RequestBody RegistroEntrenadorRequest request);
}
