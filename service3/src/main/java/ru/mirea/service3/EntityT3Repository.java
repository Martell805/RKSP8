package ru.mirea.service3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "entity", path = "entity", excerptProjection = EntityT3Projection.class)
public interface EntityT3Repository extends JpaRepository<EntityT3, Long> {
}