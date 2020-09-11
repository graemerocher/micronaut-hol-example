package example.atp.services;

import java.util.concurrent.CompletableFuture;

public interface PetHealthOperations {
    CompletableFuture<PetHealth> getHealth(String name);

    enum PetHealth {
        UNKNOWN,
        GOOD,
        REQUIRES_VACCINATION
    }
}
