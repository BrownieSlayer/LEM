package daobackup.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import daobackup.IDAOOffre;
//import model.Application;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Offre;

@Repository
@Transactional
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
	public Offre findById(Integer id) {
		return this.em
				.createQuery("select o from Offre o where o.id = ?1", Offre.class)
				.setParameter(1,id)
				.getSingleResult();
	}

	@Override
	public List<Offre> findAll() {
		return this.em
				.createQuery("select o from Offre o", Offre.class)
				.getResultList();
	}

	@Override
	public void save(Offre t) {
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
	public void deleteById(Integer id) {
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
	
	@Override
	public List<Offre> selectOffreByCompte(Integer id) {	
		return this.em
				.createQuery("select o from Offre o where ?1 = o.joueur.id or ?1 = o.manager.id", Offre.class)
				.setParameter(1,id)
				.getResultList();
	}
	@Override
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



}