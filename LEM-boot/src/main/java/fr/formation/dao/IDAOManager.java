package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.formation.model.Manager;
import fr.formation.projection.CompteProjection;

@RepositoryRestResource(excerptProjection = CompteProjection.class)
public interface IDAOManager extends JpaRepository<Manager, Integer>{
	
}
