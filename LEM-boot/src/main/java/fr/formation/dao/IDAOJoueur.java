package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.formation.model.Joueur;
import fr.formation.projection.CompteProjection;

@RepositoryRestResource(excerptProjection = CompteProjection.class)
public interface IDAOJoueur extends JpaRepository<Joueur, Integer>{
	
}
