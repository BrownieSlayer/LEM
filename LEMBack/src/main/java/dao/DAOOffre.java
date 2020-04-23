package dao;

import java.util.List;

import model.Offre;

public interface DAOOffre extends DAO<Offre,Integer> {
	
	public Offre selectOffreByIds(Integer id_joueur, Integer id_manager);
	
	public List<Offre> selectAll(Integer id);
	
	public void delete(Integer id_joueur, Integer id_manager);
	
}

