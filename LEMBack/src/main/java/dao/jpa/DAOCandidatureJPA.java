package dao.jpa;

import java.util.List;

import dao.IDAOCandidature;
import model.Candidature;
import model.Joueur;
import model.Manager;
import model.Offre;

public class DAOCandidatureJPA extends DAOJPA implements IDAOCandidature {

	@Override
	public void insert(Candidature t) {
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
	public Candidature selectById(Integer id) {
		return this.em
				.createQuery("select c from Candidature c where c.id = ?1", Candidature.class)
				.setParameter(1,id)
				.getSingleResult();
	}

	@Override
	public List<Candidature> selectAll() {
		return this.em
				.createQuery("select c from Candidature c", Candidature.class)
				.getResultList();
	}

	@Override
	public void update(Candidature t) {
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

	@Override
	public Candidature selectCandidatureByIds(Integer id_joueur, Integer id_manager) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Candidature> selectCandidatureByCompte(Integer id) {
		return this.em
				.createQuery("select c from Candidature c where ?1 = c.joueur.id or ?1 = c.manager.id", Candidature.class)
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
