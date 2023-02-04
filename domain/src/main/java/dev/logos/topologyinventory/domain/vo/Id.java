package dev.logos.topologyinventory.domain.vo;

import java.util.UUID;

import lombok.Data;

@Data
public class Id {
    private final UUID id;

    private Id(UUID id) {
        this.id = id;
    }

    public static Id withId(String id) {
        return new Id(UUID.fromString(id));
    }

    public static Id withoutId() {
        return new Id(UUID.randomUUID());
    }
}
