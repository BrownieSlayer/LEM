package dao;

import java.util.List;

import model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer> {
	
	public void updateSalmin(Compte c, double newSalmin);
	
	public void updateRole(Compte c, String newRole);
	
	public Compte checkConnect(String login,String password);
	
	public Compte selectByPseudo(String pseudo);
	
	public Compte selectByLogin(String login);
	
}

