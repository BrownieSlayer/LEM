package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import application.Test_App;
import dao.DAOCompte;
import dao.DAOCompteJDBC;
import dao.DAOCompteJPA;
import dao.DAOOffre;
import dao.DAOOffreJDBC;


public class Application {

	///Attributs
	private Connection connection=null;
	private static  Application _instance=null;
	private LinkedList<Joueur> candidats = new LinkedList();
	private DAOCompte daoC = new DAOCompteJDBC();
	private DAOOffre daoO = new DAOOffreJDBC();



	///Getters Setters
	public static Application getInstance() 
	{
		if(_instance==null) 
		{
			_instance=new Application();
		}
		return _instance;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/esport","root","");
		return connection;
	}

	public LinkedList<Joueur> getCandidats() {
		return candidats;
	}

	public void setCandidats(LinkedList<Joueur> candidats) {
		this.candidats = candidats;
	}

	public DAOCompte getDaoC() {
		return daoC;
	}

	public void setDaoC(DAOCompteJDBC daoC) {
		this.daoC = daoC;
	}

	public DAOOffre getDaoO() {
		return daoO;
	}

	public void setDaoO(DAOOffreJDBC daoO) {
		this.daoO = daoO;
	}



	///Methodes
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

	public static double saisieDouble(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	//Compte
	public static void addCompte()
	{
		System.out.println("Bienvenue dans l'espace de création de votre compte d'Esport Manager");
		String pseudo = saisieString("Saisir votre pseudo");
		DAOCompte daoC = Application.getInstance().getDaoC();
		Compte c = daoC.selectByPseudo(pseudo);

		int choix = 0;

		if(c == null)
		{
			while (!(choix == 1 || choix == 2))
			{
				choix = saisieInt("Voulez-vous créer un compte: \n 1 - joueur \n 2 - manager");
			}

			if (choix == 1)
			{
				String login = saisieString("Saisissez votre login");
				String password = saisieString("Saisissez votre mot de passe");
				String nom = saisieString("Saisissez votre nom");
				String prenom = saisieString("Saisissez votre prenom");
				String equipe = saisieString("Saisissez votre equipe");
				String role = saisieString("Saisissez votre rôle");
				double salmin = saisieDouble("Saisissez votre salaire désiré");
				double elimination = saisieDouble("Saisissez vos statistiques d'éliminations moyennes");
				double mort = saisieDouble("Saisissez vos statistiques de morts moyennes");
				double assist = saisieDouble("Saisissez vos statistiques d'assistances moyennes");

				c=new Joueur (login, password, nom, prenom, pseudo, equipe, role, salmin, elimination, mort, assist);
				daoC.insert(c);

				System.out.println("Le compte a été créé avec succès");

			}
			else if (choix == 2)
			{
				String login = saisieString("Saisissez votre login");
				String password = saisieString("Saisissez votre mot de passe");
				String nom = saisieString("Saisissez votre nom");
				String prenom = saisieString("Saisissez votre prenom");
				String equipe = saisieString("Saisissez votre equipe");

				c=new Manager(login, password, nom, prenom, pseudo, equipe);
				daoC.insert(c);

				System.out.println("Le compte a été créé avec succès");

			}

			else {

				String reessaie = saisieString("Ce compte existe déjà!\nVoulez-vous rééssayer? (Oui/Non)");
				switch(reessaie) 
				{
				case "Oui" : Application.addCompte();break;
				case "Non" : Test_App.home(); break;
				default : Test_App.home(); break;
				}
			}
		}
	}
	public static void deleteCompte(String user)
	{
		DAOCompte daoC = Application.getInstance().getDaoC();
		Compte c = daoC.selectByPseudo(user);

		if(c != null)
		{
			daoC.delete(c.getId());
			System.out.println("Le compte de "+ c.getPseudo() + " a été supprimmé avec succès");
		}
		else
		{
			System.out.println();
		}


	}

	public static void afficheCompte()
	{
		String pseudo = saisieString("Saisir le pseudo du joueur ou du manager à afficher");
		DAOCompte daoC = Application.getInstance().getDaoC();
		Compte c = daoC.selectByPseudo(pseudo);

		System.out.println(c);
	}

	public static void afficheCompteUser(String user)
	{
		DAOCompte daoC = Application.getInstance().getDaoC();
		Compte c = daoC.selectByPseudo(user);

		System.out.println(c);
	}

	public static void afficheCompteByRole()
	{

	}

	public static void afficheCompteBySalaire()
	{


	}

	public static void modifSalaireJoueur(String user)
	{
		DAOCompte daoC = Application.getInstance().getDaoC();
		int newSalmin = saisieInt("Saisir le nouveau salaire désiré");
		Compte c = daoC.selectByPseudo(user);

		if (c.getTypeCompte().equals("joueur"))
		{
			daoC.updateSalmin(c,newSalmin);
		}
		else
		{
			System.out.println("Ce compte ne peut changer son salaire");
		}

	}

	public static void modifRoleJoueur(String user)
	{
		DAOCompte daoC = Application.getInstance().getDaoC();
		String newRole = saisieString("Saisir le nouveau à afficher");
		Compte c = daoC.selectByPseudo(user);
		if (c.getTypeCompte().equals("joueur"))
		{
			daoC.updateRole(c,newRole);
		}
		else
		{
			System.out.println("Ce compte ne peut changer son rôle");
		}
	}


	//Offre
	public static void addOffre(String user)
	{
		System.out.println("Bienvenue dans l'espace de création d'une offre de recrutement");

		DAOOffre daoO = Application.getInstance().getDaoO();
		DAOCompte daoC = Application.getInstance().getDaoC();

		Compte cm = daoC.selectByPseudo(user);

		String pseudo = saisieString("Saisissez le pseudo du joueur que vous voulez recruter");
		Compte c = daoC.selectByPseudo(pseudo);

		System.out.println(c);

		int id_joueur = c.getId();
		int id_manager = cm.getId();
		int salairePropose = saisieInt("Saisissez le salaire que vous voulez proposer à " + pseudo);
		String equipePropose = cm.getEquipe();
		String rolePropose = saisieString("Saisissez le rôle que vous voulez proposer");
		
		Offre o = null;
		//Offre o = new Offre (id_joueur, id_manager, salairePropose, equipePropose, rolePropose);
		daoO.insert(o);

		System.out.println("L'offre de recrutement de " + c.getPseudo() + " pour un salaire de " + salairePropose + " a bien été envoyé");
	}

	//public Offre(int id_joueur, int id_manager, double salairePropose, String equipePropose,String rolePropose)

	public static void deleteOffreManager(String user)
	{
		String pseudo = saisieString("Saisir le pseudo du joueur lié à l'offre que vous voulez supprimmer");

		DAOOffre daoO = Application.getInstance().getDaoO();
		DAOCompte daoC = Application.getInstance().getDaoC();

		Compte cm = daoC.selectByPseudo(user);
		Compte c = daoC.selectByPseudo(pseudo);

		if(c != null & cm != null)
		{
			int id_manager = cm.getId();
			int id_joueur = c.getId();
			daoO.delete(id_joueur,id_manager);
		}
	}

	public static void afficheOffreByPseudos(String user)
	{
		String pseudo = saisieString("Saisir le pseudo du joueur lié à l'offre que vous voulez afficher");

		DAOOffre daoO = Application.getInstance().getDaoO();
		DAOCompte daoC = Application.getInstance().getDaoC();

		Compte cm = daoC.selectByPseudo(user);
		Compte c = daoC.selectByPseudo(pseudo);

		if(c != null & cm != null)
		{
			int id_manager = cm.getId();
			int id_joueur = c.getId();
			Offre o = daoO.selectOffreByIds(id_joueur,id_manager);
			System.out.println(o);
		}
		else
		{
			System.out.println("L'offre ne semble pas exister");
		}

	}


	public Compte checkConnect(String login,String password)
	{
		DAOCompteJDBC daoC= new DAOCompteJDBC();
		Compte c=daoC.checkConnect(login, password);	
		return c;
	}

}
