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

public class DAOCompteJPA extends DAOJPA implements IDAOCompte {

	@Override
	public void insert(Compte Entity) {
		this.em.getTransaction().begin();
		try {
			this.em.persist(Entity);
			this.em.getTransaction().commit();
		
		}
		catch(Exception e) {
			this.em.getTransaction().commit();
		}
			
	}

	@Override
	public Compte selectById(Integer id) {
		
		return this.em.find(Compte.class, id);
	}

	@Override
	public List<Compte> selectAll() {
		return em.createQuery( "select c from Compte c", Compte.class).getResultList();
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
		return this.em.find(Compte.class, pseudo);
		
	}

	@Override
	public Compte selectByLogin(String login) {
		return this.em.find(Compte.class, login);
	}

}