package example.atp.domain;

import java.util.UUID;

import example.atp.domain.Owner;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

@MappedEntity
public record Pet(
    @Id @AutoPopulated @Nullable UUID id, 
    String name, 
    @Relation(Relation.Kind.MANY_TO_ONE)
    Owner owner, 
    @Nullable
    PetType type) {
        
    public Pet {
        if (type == null) {
            type = PetType.DOG;
        }
    }

    public Pet(String name, Owner owner) {
        this(null, name, owner, null);
    }

    public Pet(String name, Owner owner, PetType type) {
        this(null, name, owner, type);
    }

    public enum PetType {
        DOG,
        CAT
    }
}
