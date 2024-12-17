package ru.mirea.service2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "entity", path = "entity", excerptProjection = EntityT2Projection.class)
public interface EntityT2Repository extends JpaRepository<EntityT2, Long> {
}