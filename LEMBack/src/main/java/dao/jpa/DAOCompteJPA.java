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
			e.printStackTrace();
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
		
		this.em.getTransaction().begin(); //On d�marre la transaction

		try {
			this.em.merge(entity);
			this.em.getTransaction().commit(); //On commit la transaction
		}

		catch (Exception e) { //Y'a un probl�me ??
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
	@Override
	public void updateSalmin(Joueur joueur, double newSalmin) {
		
		this.em.getTransaction().begin();

		try {
			joueur.setSalmin(newSalmin);
			this.em.merge(joueur);	
			this.em.getTransaction().commit(); 
		}

		catch (Exception e) {
			this.em.getTransaction().rollback(); 
		}

		
	}
	
	@Override
	public void updateRole(Joueur joueur, String newRole) {
		System.out.println("COUCOU");
		this.em.getTransaction().begin();

		try {
			joueur.setRole(newRole);
			this.em.merge(joueur);	
			this.em.getTransaction().commit(); 
		}

		catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback(); 
		}
		
	}

	@Override
	public Compte checkConnect(String login, String password) {
		return this.em
				.createQuery("select c from Compte c where c.login=?1 and c.password=?2", Compte.class)
				.setParameter(1, login)
				.setParameter(2, password)
				.getSingleResult();
	}

	@Override
	public Compte selectByPseudo(String pseudo) {
		return this.em
				.createQuery("select c from Compte c where c.pseudo = ?1", Compte.class)
				.setParameter(1, pseudo)
				.getSingleResult();
		
	}

	@Override
	public Compte selectByLogin(String login) {
		return this.em
				.createQuery("select c from Compte c where c.login = ?1", Compte.class)
				.setParameter(1, login)
				.getSingleResult();
	}



}