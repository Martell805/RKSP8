package ru.mirea.service2;

import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name = "entity", types = { EntityT2.class })
public interface EntityT2Projection {
    UUID getId();
    String getDesc();
}