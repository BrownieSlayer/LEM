package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Joueur")
public class Joueur extends Compte{

	///Attributs
	@Column(name ="role")
	private String role;
	@Column(name ="salmin")
	private double salmin;
	@Column(name ="elimination")
	private double elimination;
	@Column(name ="mort")
	private double mort;
	@Column(name ="assist")
	private double assist;
	@Column(name ="kda")
	private double kda; 
	@OneToMany(mappedBy = "joueur")
	List<Offre> offres = new ArrayList<>();
	@OneToMany (mappedBy = "joueur")
	List<Candidature> candidatures = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="id_manager")
	private Manager manager;
	
	///Constructeurs
	public Joueur(String login, String password, String nom, String prenom, String pseudo, String equipe, Manager manager, String role,
			double salmin, double elimination, double mort, double assist) {
		
		super(login, password, nom, prenom, pseudo, equipe);
		this.role = role;
		this.salmin = salmin;
		this.elimination = elimination;
		this.mort = mort;
		this.assist = assist;
		this.kda = (elimination+assist)/mort;
		this.typeCompte = "joueur";
		this.manager = manager;
	}
	
	public Joueur(String login, String password, String nom, String prenom, String pseudo, String equipe, String role,
			double salmin, double elimination, double mort, double assist) {
		
		super(login, password, nom, prenom, pseudo, equipe);
		this.role = role;
		this.salmin = salmin;
		this.elimination = elimination;
		this.mort = mort;
		this.assist = assist;
		this.kda = (elimination+assist)/mort;
		this.typeCompte = "joueur";
	}
	
	public Joueur() {}
	
	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	///Constructeurs
	public Joueur(int id, String login, String password, String nom, String prenom, String pseudo, String equipe, String role,
			double salmin, double elimination, double mort, double assist) {
		super(login, password, nom, prenom, pseudo, equipe);
		this.id = id;
		this.role = role;
		this.salmin = salmin;
		this.elimination = elimination;
		this.mort = mort;
		this.assist = assist;
		this.kda = (elimination+assist)/mort;
		this.typeCompte = "joueur";
	}

	///Getters Setters
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalmin() {
		return salmin;
	}

	public void setSalmin(double salmin) {
		this.salmin = salmin;
	}

	public double getElimination() {
		return elimination;
	}

	public void setElimination(double elimination) {
		this.elimination = elimination;
	}

	public double getMort() {
		return mort;
	}

	public void setMort(double mort) {
		this.mort = mort;
	}

	public double getAssist() {
		return assist;
	}

	public void setAssist(double assist) {
		this.assist = assist;
	}

	public double getKda() {
		return kda;
	}

	public void setKda(double kda) {
		this.kda = kda;
	}
	
	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	///M�thodes
	public static String saisieString(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public static int saisieInt(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public void menuModifInfo()
	{
		int quit = 0;
		while (quit == 0)
		{
			System.out.println("Voulez-vous modifier une de vos informations ?");
			System.out.println("1 - Modifier son salaire");
			System.out.println("2 - Modifier son r�le ");
			System.out.println("3 - Quitter");
			int choix = saisieInt("Saisissez votre choix");
			
			switch(choix)
			{
				case 1 : modifSalmin();menuModifInfo();break;
				case 2 : modifRole();menuModifInfo();break;
				//case 3 : accueil();break;
			}
		}
	}
	
	public void modifRole()
	{
		String newRole = "";	
		do 
		{
			newRole = saisieString("Veuillez renseigner un r�le pr�sent dans la liste (Top/Jungler/Mid/ADC/Support)");	
		} while(!(newRole.equals("Top") || newRole.contentEquals("Jungler") || newRole.contentEquals("Mid") || newRole.contentEquals("ADC") || newRole.contentEquals("Support")));
		this.role = newRole;
	}
	
	public void modifSalmin()
	{
		String newRole = "";	
		do 
		{
			newRole = saisieString("Veuillez renseigner un r�le pr�sent dans la liste (Top/Jungler/Mid/ADC/Support)");	
		} while(!(newRole.equals("Top") || newRole.contentEquals("Jungler") || newRole.contentEquals("Mid") || newRole.contentEquals("ADC") || newRole.contentEquals("Support")));
		this.role = newRole;
	}

	@Override
	public String toString() {
		return "Joueur [role=" + role + ", salmin=" + salmin + ", elimination=" + elimination + ", mort=" + mort
				+ ", assist=" + assist + ", kda=" + kda + ", id=" + id + ", login=" + login + ", password=" + password
				+ ", typeCompte=" + typeCompte + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo
				+ ", equipe=" + equipe + "]";
	}
	
}


