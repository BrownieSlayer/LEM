package dao.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOOffre;
import model.Application;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Offre;

public class DAOOffreJPA extends DAOJPA implements IDAOOffre {

	@Override
	public void insert(Offre t) {
		this.em.getTransaction().begin();
		try {
		this.em.persist(t);
		this.em.getTransaction().commit();
		}
		catch(Exception e) {
			this.em.getTransaction().rollback();
		}	
	}

	@Override
	public Offre selectById(Integer id) {
		return this.em
				.createQuery("select o from Offre o where o.id = ?1", Offre.class)
				.setParameter(1,id)
				.getSingleResult();
	}

	@Override
	public List<Offre> selectAll() {
		return this.em
				.createQuery("select o from Offre o", Offre.class)
				.getResultList();
	}

	@Override
	public void update(Offre t) {
		this.em.getTransaction().begin();
		try {
		this.em.merge(t);
		this.em.getTransaction().commit();
		}
		catch(Exception e) {
			this.em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			this.em.getTransaction().begin();
			Offre offreToRemove = new Offre();	
			offreToRemove.setId(id);	
			this.em.remove(this.em.merge(offreToRemove));
			this.em.getTransaction().commit();
			}catch(Exception e) {this.em.getTransaction().rollback();}
	}

	@Override //Laisser vide
	public Offre selectOffreByIds(Integer id_joueur, Integer id_manager) {
		return null;
	}
	
	public Offre selectOffreByComptes(Joueur joueur, Manager manager) {	
		return this.em
				.createQuery("select o from Offre where o.joueur = ?1 && o.manager = manager", Offre.class)
				.setParameter(1,joueur)
				.setParameter(2,manager)
				.getSingleResult();
	}

	@Override
	public List<Offre> selectAll(Integer id) {
		return this.em
				.createQuery("select o from Offre o", Offre.class)
				.getResultList();
	}

	public void delete(Joueur joueur, Manager manager) {
		try {
			this.em.getTransaction().begin();
			Offre offreToRemove = new Offre();	
			offreToRemove.setJoueur(joueur);
			offreToRemove.setManager(manager);
			this.em.remove(this.em.merge(offreToRemove));
			this.em.getTransaction().commit();
			}catch(Exception e) {this.em.getTransaction().rollback();}
		
	}

	//Laisser vide
	@Override
	public void delete(Integer id_joueur, Integer id_manager) {
		// TODO Auto-generated method stub
		
	}

}