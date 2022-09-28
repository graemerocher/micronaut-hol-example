package example.atp.domain;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record NameDTO(String name) {
}