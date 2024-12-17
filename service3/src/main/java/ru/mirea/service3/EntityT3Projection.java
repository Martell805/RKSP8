package ru.mirea.service3;

import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name = "entity", types = { EntityT3.class })
public interface EntityT3Projection {
    UUID getId();
    String getSurname();
}