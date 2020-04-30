package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Candidature;

public interface IDAOCandidature extends JpaRepository<Candidature, Integer>{
	
	@Query("select o from Offre o where o.joueur.id = ?1 or o.manager.id = ?1")
	public List<Candidature> selectCandidatureById(Integer id);

}
