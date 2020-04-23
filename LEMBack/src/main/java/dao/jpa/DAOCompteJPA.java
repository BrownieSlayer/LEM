package dao.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOCompte;
import model.Application;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Roles;

public class DAOCompteJPA implements IDAOCompte {

	@Override
	public void insert(Compte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Compte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalmin(Compte c, double newSalmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRole(Compte c, String newRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte checkConnect(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte selectByPseudo(String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte selectByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}