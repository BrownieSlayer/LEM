package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidature")
public class Candidature {
	
	@Id//OBLIGATOIRE
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne()
	@JoinColumn(name="id_joueur")
	private Joueur joueur;
	@ManyToOne()
	@JoinColumn(name="id_manager")
	private Manager manager;
	@Column(name="salaireDemande",nullable=false)
	private double salaireDemande;
	@Column(name="equipeDemande", length=25,nullable=false)
	private String equipeDemande;
	@Column(name="roleDemande", length=25,nullable=false)
	private String roleDemande;
	
	
	
	public Candidature( Joueur joueur, Manager manager, double salaireDemande, String equipeDemande,
			String roleDemande) {
		
		this.joueur = joueur;
		this.manager = manager;
		this.salaireDemande = salaireDemande;
		this.equipeDemande = equipeDemande;
		this.roleDemande = roleDemande;
	}
	public Candidature() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public double getSalaireDemande() {
		return salaireDemande;
	}
	public void setSalaireDemande(double salaireDemande) {
		this.salaireDemande = salaireDemande;
	}
	public String getEquipeDemande() {
		return equipeDemande;
	}
	public void setEquipeDemande(String equipeDemande) {
		this.equipeDemande = equipeDemande;
	}
	public String getRoleDemande() {
		return roleDemande;
	}
	public void setRoleDemande(String roleDemande) {
		this.roleDemande = roleDemande;
	}
	
	
	@Override
	public String toString() {
		return "Candidature [id=" + id + ", joueur=" + joueur + ", manager=" + manager + ", salaireDemande="
				+ salaireDemande + ", equipeDemande=" + equipeDemande + ", roleDemande=" + roleDemande + "]";
	}
	
	
	
	

}
