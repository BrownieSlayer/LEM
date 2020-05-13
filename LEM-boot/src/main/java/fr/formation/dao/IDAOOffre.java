package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Offre;

public interface IDAOOffre extends JpaRepository<Offre, Integer>{
	
	//recup la liste d'offres � partir d'un compte
	@Query("select o from Offre o where o.joueur.id = ?1 or o.manager.id = ?1")
	public List<Offre> selectOffresById(Integer id);
	
	//recup la liste d'offres � partir d'un compte
	@Query("select o from Offre o where o.joueur.login = ?1 or o.manager.login = ?1")
	public List<Offre> selectOffresByLogin(String login);

}
