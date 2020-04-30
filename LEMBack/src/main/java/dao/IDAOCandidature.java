package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Candidature;

public interface IDAOCandidature extends JpaRepository<Candidature, Integer>{
	
	@Query("select c from Candidature c where c.joueur.id = ?1 or c.manager.id = ?1")
	public List<Candidature> selectCandidatureById(Integer id);

}
