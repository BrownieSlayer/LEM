package model;

public class Compte {
	
	///Attributs
	protected static int nb_compte = 0;
	protected int id;
	protected String login;
	protected String password;
	protected String typeCompte;
	protected String nom;
	protected String prenom;
	protected String pseudo;
	protected String equipe;
	
	///Constructeurs
	public Compte(String login, String password, String nom, String prenom, String pseudo, String equipe) {
		
		nb_compte += 1;
		this.id = nb_compte;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.equipe = equipe;
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


	@Override
	public String toString() {
		return "Compte [login=" + login + ", password=" + password + ", typeCompte=" + typeCompte + ", nom=" + nom
				+ ", prenom=" + prenom + ", pseudo=" + pseudo + ", equipe=" + equipe + "]";
	}

	
	
}
