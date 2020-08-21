package example.atp;

import example.atp.services.PetHealthOperations;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;

@MicronautTest
public class PetHealthTest {
    @Inject
    PetHealthOperations petHealthOperations;

    @Test
    void testFallback() throws ExecutionException, InterruptedException {
        Assertions.assertEquals(
                PetHealthOperations.PetHealth.UNKNOWN,
                petHealthOperations.getHealth("Fred").get()
        );
    }
}
