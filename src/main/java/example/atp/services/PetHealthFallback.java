package example.atp.services;

import io.micronaut.retry.annotation.Fallback;

import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;

@Fallback
@Singleton
public class PetHealthFallback implements PetHealthOperations {
    @Override
    public CompletableFuture<PetHealth> getHealth(String name) {
        return CompletableFuture.completedFuture(PetHealthOperations.PetHealth.UNKNOWN);
    }
}
