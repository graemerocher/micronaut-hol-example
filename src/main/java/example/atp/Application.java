package example.atp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.atp.domain.Owner;
import example.atp.domain.Pet;
import example.atp.domain.Pet.PetType;
import example.atp.repositories.OwnerRepository;
import example.atp.repositories.PetRepository;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

@Singleton
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    Application(OwnerRepository ownerRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }

    @EventListener
    @Transactional
    void init(StartupEvent event) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Populating data");
        }

        petRepository.deleteAll();
        ownerRepository.deleteAll();
        Iterable<Owner> owners = ownerRepository.saveAll(List.of(
                new Owner("Fred", 45),  new Owner("Barney", 40)
        ));
        List<Pet> pets = new ArrayList<>();
        for(Owner person : owners) {
            switch(person.name()) {
                case "Fred" -> {
                    var dino = new Pet("Dino", person);
                    var bp = new Pet("Baby Puss", person, PetType.CAT);
                    pets.addAll(List.of(dino, bp));
                }
                case "Barney" -> 
                    pets.add(new Pet("Hoppy", person));
            }
        }

        petRepository.saveAll(pets);
    }
}