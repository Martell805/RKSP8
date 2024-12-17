package ru.mirea.service1;

import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name = "entity", types = { EntityT1.class })
public interface EntityT1Projection {
    UUID getId();
    String getName();
}