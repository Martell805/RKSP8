package ru.mirea.service1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "entity", path = "entity", excerptProjection = EntityT1Projection.class)
public interface EntityT1Repository extends JpaRepository<EntityT1, Long> {
}