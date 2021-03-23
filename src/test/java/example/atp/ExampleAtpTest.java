package example.atp;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
public class ExampleAtpTest {

    @Inject
    EmbeddedApplication application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

}
