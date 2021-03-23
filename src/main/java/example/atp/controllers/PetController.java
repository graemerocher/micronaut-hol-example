package example.atp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import example.atp.domain.NameDTO;
import example.atp.domain.Pet;
import example.atp.repositories.PetRepository;
import example.atp.services.PetHealthOperations;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@Controller("/pets")
@ExecuteOn(TaskExecutors.IO)
class PetController {

    private final PetRepository petRepository;
    private final PetHealthOperations petHealthOperations;

    PetController(PetRepository petRepository, PetHealthOperations petHealthOperations) {
        this.petRepository = petRepository;
        this.petHealthOperations = petHealthOperations;
    }

    @Get("/")
    List<NameDTO> all() {
        return petRepository.list();
    }

    @Get("/{name}")
    Optional<Pet> byName(String name) {
        return petRepository.findByName(name);
    }

    @Get("/{name}/health")
    CompletableFuture<PetHealthOperations.PetHealth> getHealth(String name) {
        return petHealthOperations.getHealth(name);
    }
}