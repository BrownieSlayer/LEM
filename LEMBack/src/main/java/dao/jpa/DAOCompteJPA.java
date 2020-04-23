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

	public void insert(Compte entity) {
		
		this.em.getTransaction().begin();
		try {
			this.em.persist(entity);
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
	public void update(Compte entity) {
		
		this.em.getTransaction().begin(); //On démarre la transaction

		try {
			this.em.merge(entity);
			this.em.getTransaction().commit(); //On commit la transaction
		}

		catch (Exception e) { //Y'a un problème ??
			this.em.getTransaction().rollback(); //On annule la transaction
		}

		
	}

	@Override
	public void delete(Integer id) {
		
		try {
			this.em.getTransaction().begin();
		
		Compte compteToRemove = new Compte();
		compteToRemove.setId(id);
		
		this.em.remove(this.em.merge(compteToRemove));
		
		this.em.getTransaction().commit();
		
		}
		
		catch (Exception e) {
			
			this.em.getTransaction().rollback();
		}
		
	}

	public void updateSalmin(Joueur joueur, double newSalmin) {
		
		this.em.getTransaction().begin();

		try {
			int id=joueur.getId();
			
			this.em
			.createQuery("UPDATE compte c SET c.salmin = ?1 WHERE c.id = ?2")
			.setParameter(1,newSalmin)
			.setParameter(2,id)
			.executeUpdate();
			
			this.em.getTransaction().commit(); 
		}

		catch (Exception e) {
			this.em.getTransaction().rollback(); 
		}

		
	}

	public void updateRole(Joueur joueur, String newRole) {
		
		this.em.getTransaction().begin();

		try {
			int id=joueur.getId();
			
			this.em
			.createQuery("UPDATE compte c SET c.role = ?1 WHERE c.id = ?2")
			.setParameter(1,newRole)
			.setParameter(2,id)
			.executeUpdate();
			
			this.em.getTransaction().commit(); 
		}

		catch (Exception e) {
			this.em.getTransaction().rollback(); 
		}
		
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

	@Override
	public void updateRole(Compte c, String newRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalmin(Compte c, double newSalmin) {
		// TODO Auto-generated method stub
		
	}

}