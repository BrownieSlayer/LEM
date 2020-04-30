package daobackup;

import java.util.List;

import model.Joueur;
import model.Manager;
import model.Offre;

public interface IDAOOffre extends IDAO<Offre,Integer> {
	
	public Offre selectOffreByIds(Integer id_joueur, Integer id_manager);
	
	public void delete(Joueur joueur, Manager manager);
	
	public  List<Offre> selectOffreByCompte(Integer id);

	
}

