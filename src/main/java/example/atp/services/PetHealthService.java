package example.atp.services;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;

import java.util.concurrent.CompletableFuture;

@Client(value = "pet-health")
@Recoverable(api = PetHealthOperations.class)
public interface PetHealthService extends PetHealthOperations {
    @Override
    @Get("/pets/{name}/health")
    CompletableFuture<PetHealth> getHealth(String name);
}
