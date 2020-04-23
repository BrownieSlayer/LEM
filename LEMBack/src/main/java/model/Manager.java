package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Compte {

	///Attributs
	@OneToMany(mappedBy = "manager")
	List<Joueur> joueurManage = new ArrayList();
	@OneToMany(mappedBy = "manager")
	List<Offre> offreJoueur = new ArrayList();
	
	///Constructeurs
	
	///Getters Setters
	public List<Joueur> getJoueurManage() {
		return joueurManage;
	}

	public Manager(String login, String password, String nom, String prenom, String pseudo, String equipe) {
		super(login, password, nom, prenom, pseudo, equipe);
		this.typeCompte = "manager";
	}

	public Manager(int id, String login, String password, String nom, String prenom, String pseudo, String equipe) {
		super(login, password, nom, prenom, pseudo, equipe);
		this.id = id;
		this.typeCompte = "manager";
	}
	
	public Manager() {}
	
	public List<Offre> getOffreJoueur() {
		return offreJoueur;
	}

	public void setJoueurManage(List<Joueur> joueurManage) {
		this.joueurManage = joueurManage;
	}

	public List<Offre> getoffreJoueur() {
		return offreJoueur;
	}

	public void setOffreJoueur(List<Offre> propositionJoueur) {
		this.offreJoueur = propositionJoueur;
	}
	
	///Méthodes
	public void virerJoueur()
	{
		
	}


	public void checkInfo()
	{
		
	}
	
	public void recruterJoueur(String pseudo)
	{
		
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", login=" + login + ", password=" + password + ", typeCompte=" + typeCompte
				+ ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", equipe=" + equipe + "]";
	}
	
	
}
