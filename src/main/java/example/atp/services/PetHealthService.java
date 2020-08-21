package example.atp.services;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.concurrent.CompletableFuture;

@Requires(property = "pet.health.endpoint")
@Client("${pet.health.endpoint}")
public interface PetHealthService extends PetHealthOperations {
    @Override
    @Get("/pets/{name}/health")
    CompletableFuture<PetHealth> getHealth(String name);
}
