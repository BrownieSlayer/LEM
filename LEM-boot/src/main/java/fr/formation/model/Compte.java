package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.projection.Views;

@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "typecompte")

public class Compte {
	
	///Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(Views.Common.class)
	protected int id;
	
	@Column(name="login", length=50, nullable=false)
	@JsonView(Views.Compte.class)
	protected String login;
	
	@Column(name="password", length=250, nullable=false)
	protected String password;
	
	@Column(name="typecompte", length=50, insertable = false, updatable = false)
	protected String typeCompte;
	
	@Column(name="nom", length=50, nullable=false)
	protected String nom;
	
	@Column(name="prenom", length=50, nullable=false)
	protected String prenom;
	
	@Column(name="pseudo", length=50, nullable=false)
	protected String pseudo;
	
	@Column(name="equipe")
	protected String equipe;
	
	@Column(name="description", length=400)
	protected String description;
	
	///Constructeurs
	//Constructeur complet
	public Compte(String login, String password, String nom, String prenom, String pseudo, String equipe, String description) {	
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.equipe = equipe;
		this.description=description;
	}
	//Constructeur sans description
	public Compte(String login, String password, String nom, String prenom, String pseudo, String equipe) {	
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.equipe = equipe;
	}
	//Constructeur sans description ni equipe
	public Compte(String login, String password, String nom, String prenom, String pseudo) {	
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.equipe = null;
		this.description=null;
		
	}
	

	public Compte() {
	}




	///Getters / Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
		
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Compte [login=" + login + ", password=" + password + ", typeCompte=" + typeCompte + ", nom=" + nom
				+ ", prenom=" + prenom + ", pseudo=" + pseudo + ", equipe=" + equipe + "]";
	}

	
	
}
