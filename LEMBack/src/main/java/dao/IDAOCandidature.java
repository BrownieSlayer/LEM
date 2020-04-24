package dao;

import java.util.List;

import model.Candidature;
import model.Joueur;
import model.Manager;


public interface IDAOCandidature extends IDAO<Candidature,Integer>{

	public Candidature selectCandidatureByIds(Integer id_joueur, Integer id_manager);
	
	public void delete(Joueur joueur, Manager manager);
	
	public  List<Candidature> selectCandidatureByCompte(Integer id);

}
