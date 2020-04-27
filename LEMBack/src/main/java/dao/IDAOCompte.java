package dao;

import java.util.List;

import model.Compte;
import model.Joueur;
import model.Manager;

public interface IDAOCompte extends IDAO<Compte,Integer> {
	
	public void updateSalmin(Joueur j, double newSalmin);
	
	public void updateRole(Joueur j, String newRole);
	
	public Compte checkConnect(String login,String password);
	
	public Compte selectByPseudo(String pseudo);
	
	public Compte selectByLogin(String login);
	
	public List<Compte> selectTeam (Manager m);
	
	public void updatedescription(Compte c, String description);
	
}

