package example.atp.services;

import java.util.concurrent.CompletableFuture;

import javax.inject.Singleton;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;

@Singleton
@Recoverable(api = PetHealthOperations.class)
public class PetHealthService implements PetHealthOperations {
    private final PetHealthClient petHealthClient;

    PetHealthService(PetHealthClient petHealthClient) {
        this.petHealthClient = petHealthClient;
    }

    @Override
    public CompletableFuture<PetHealth> getHealth(String name) {
        if (petHealthClient.isVaccinated(name)) {
            return CompletableFuture.completedFuture(PetHealth.GOOD);
        }
        return CompletableFuture.completedFuture(PetHealth.REQUIRES_VACCINATION);
    }

    @Client(value = "pet-health", path ="/vaccinated")
    public interface PetHealthClient {
        @Get("/{name}")
        boolean isVaccinated(String name);
    }
}
