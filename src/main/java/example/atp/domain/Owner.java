package example.atp.domain;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.GeneratedValue.Type;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public record Owner(
    @Id @GeneratedValue(Type.IDENTITY) @Nullable Long id, 
    String name, 
    int age) {
    public Owner(String name, int age) {
        this(null, name, age);
    }
}