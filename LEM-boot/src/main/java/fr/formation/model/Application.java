package fr.formation.model;
//package model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//import application.Test_App;
//import daobackup.IDAOCompte;
//import daobackup.IDAOOffre;
//import daobackup.jdbc.DAOCompteJDBC;
//import daobackup.jdbc.DAOOffreJDBC;
//
//
//public class Application {
//
//	///Attributs
//	private Connection connection=null;
//	private static  Application _instance=null;
//	private LinkedList<Joueur> candidats = new LinkedList<>();
////	private IDAOCompte daoC = new DAOCompteJDBC();
////	private IDAOOffre daoO = new DAOOffreJDBC();
//
//
//
//	///Getters Setters
//	public static Application getInstance() 
//	{
//		if(_instance==null) 
//		{
//			_instance=new Application();
//		}
//		return _instance;
//	}
//
//	public Connection getConnection() throws ClassNotFoundException, SQLException 
//	{
//		Class.forName("com.mysql.jdbc.Driver");
//		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/esport","root","");
//		return connection;
//	}
//
//	public LinkedList<Joueur> getCandidats() {
//		return candidats;
//	}

//	public void setCandidats(LinkedList<Joueur> candidats) {
//		this.candidats = candidats;
//	}
//
//	public IDAOCompte getDaoC() {
//		return daoC;
//	}
//
//	public void setDaoC(DAOCompteJDBC daoC) {
//		this.daoC = daoC;
//	}
//
//	public IDAOOffre getDaoO() {
//		return daoO;
//	}
//
//	public void setDaoO(DAOOffreJDBC daoO) {
//		this.daoO = daoO;
//	}
//
//
//
//	///Methodes
//	public static String saisieString(String msg) 
//	{
//		Scanner sc=new Scanner(System.in);
//		System.out.println(msg);
//		return sc.nextLine();
//	}
//
//	public static int saisieInt(String msg) 
//	{
//		Scanner sc=new Scanner(System.in);
//		System.out.println(msg);
//		return sc.nextInt();
//	}
//
//	public static double saisieDouble(String msg) 
//	{
//		Scanner sc=new Scanner(System.in);
//		System.out.println(msg);
//		return sc.nextDouble();
//	}
//
//	//Compte
//	public static void addCompte()
//	{
//		System.out.println("Bienvenue dans l'espace de cr�ation de votre compte d'Esport Manager");
//		String pseudo = saisieString("Saisir votre pseudo");
//		IDAOCompte daoC = Application.getInstance().getDaoC();
//		Compte c = daoC.selectByPseudo(pseudo);
//
//		int choix = 0;
//
//		if(c == null)
//		{
//			while (!(choix == 1 || choix == 2))
//			{
//				choix = saisieInt("Voulez-vous cr�er un compte: \n 1 - joueur \n 2 - manager");
//			}
//
//			if (choix == 1)
//			{
//				String login = saisieString("Saisissez votre login");
//				String password = saisieString("Saisissez votre mot de passe");
//				String nom = saisieString("Saisissez votre nom");
//				String prenom = saisieString("Saisissez votre prenom");
//				String equipe = saisieString("Saisissez votre equipe");
//				String role = saisieString("Saisissez votre r�le");
//				double salmin = saisieDouble("Saisissez votre salaire d�sir�");
//				double elimination = saisieDouble("Saisissez vos statistiques d'�liminations moyennes");
//				double mort = saisieDouble("Saisissez vos statistiques de morts moyennes");
//				double assist = saisieDouble("Saisissez vos statistiques d'assistances moyennes");
//
//
//				c=new Joueur (login, password, nom, prenom, pseudo, equipe, role, salmin, elimination, mort, assist);
//				daoC.insert(c);
//
//				System.out.println("Le compte a �t� cr�� avec succ�s");
//
//			}
//			else if (choix == 2)
//			{
//				String login = saisieString("Saisissez votre login");
//				String password = saisieString("Saisissez votre mot de passe");
//				String nom = saisieString("Saisissez votre nom");
//				String prenom = saisieString("Saisissez votre prenom");
//				String equipe = saisieString("Saisissez votre equipe");
//
//				c=new Manager(login, password, nom, prenom, pseudo, equipe);
//				daoC.insert(c);
//
//				System.out.println("Le compte a �t� cr�� avec succ�s");
//
//			}
//
//			else {
//
//				String reessaie = saisieString("Ce compte existe d�j�!\nVoulez-vous r��ssayer? (Oui/Non)");
//				switch(reessaie) 
//				{
//				case "Oui" : Application.addCompte();break;
//				case "Non" : Test_App.home(); break;
//				default : Test_App.home(); break;
//				}
//			}
//		}
//	}
//	public static void deleteCompte(String user)
//	{
//		IDAOCompte daoC = Application.getInstance().getDaoC();
//		Compte c = daoC.selectByPseudo(user);
//
//		if(c != null)
//		{
//			daoC.delete(c.getId());
//			System.out.println("Le compte de "+ c.getPseudo() + " a �t� supprimm� avec succ�s");
//		}
//		else
//		{
//			System.out.println();
//		}
//
//
//	}
//
//	public static void afficheCompte()
//	{
//		String pseudo = saisieString("Saisir le pseudo du joueur ou du manager � afficher");
//		IDAOCompte daoC = Application.getInstance().getDaoC();
//		Compte c = daoC.selectByPseudo(pseudo);
//
//		System.out.println(c);
//	}
//
//	public static void afficheCompteUser(String user)
//	{
//		IDAOCompte daoC = Application.getInstance().getDaoC();
//		Compte c = daoC.selectByPseudo(user);
//
//		System.out.println(c);
//	}
//
//	public static void afficheCompteByRole()
//	{
//
//	}
//
//	public static void afficheCompteBySalaire()
//	{
//
//
//	}
//
//	public static void modifSalaireJoueur(String user)
//	{
//		/*IDAOCompte daoC = Application.getInstance().getDaoC();
//		int newSalmin = saisieInt("Saisir le nouveau salaire d�sir�");
//		Compte c = daoC.selectByPseudo(user);
//
//		if (c.getTypeCompte().equals("Joueur"))
//		{
//			daoC.updateSalmin(c,newSalmin);
//		}
//		else
//		{
//			System.out.println("Ce compte ne peut changer son salaire");
//		}*/
//
//	}
//
//	public static void modifRoleJoueur(String user)
//	{
//		/*IDAOCompte daoC = Application.getInstance().getDaoC();
//		String newRole = saisieString("Saisir le nouveau � afficher");
//		Compte c = daoC.selectByPseudo(user);
//		if (c.getTypeCompte().equals("joueur"))
//		{
//			daoC.updateRole(c,newRole);
//		}
//		else
//		{
//			System.out.println("Ce compte ne peut changer son r�le");
//		}*/
//	}
//
//
//	//Offre
//	public static void addOffre(String user)
//	{
//		System.out.println("Bienvenue dans l'espace de cr�ation d'une offre de recrutement");
//
//		IDAOOffre daoO = Application.getInstance().getDaoO();
//		IDAOCompte daoC = Application.getInstance().getDaoC();
//
//		Compte cm = daoC.selectByPseudo(user);
//
//		String pseudo = saisieString("Saisissez le pseudo du joueur que vous voulez recruter");
//		Compte c = daoC.selectByPseudo(pseudo);
//
//		System.out.println(c);
//
//		int id_joueur = c.getId();
//		int id_manager = cm.getId();
//		int salairePropose = saisieInt("Saisissez le salaire que vous voulez proposer � " + pseudo);
//		String equipePropose = cm.getEquipe();
//
//
//		System.out.println("L'offre de recrutement de " + c.getPseudo() + " pour un salaire de " + salairePropose + " a bien �t� envoy�");
//	}
//
//	//public Offre(int id_joueur, int id_manager, double salairePropose, String equipePropose,String rolePropose)
//
//	public static void deleteOffreManager(String user)
//	{
////		String pseudo = saisieString("Saisir le pseudo du joueur li� � l'offre que vous voulez supprimmer");
////
////		IDAOOffre daoO = Application.getInstance().getDaoO();
////		IDAOCompte daoC = Application.getInstance().getDaoC();
////
////		Compte cm = daoC.selectByPseudo(user);
////		Compte c = daoC.selectByPseudo(pseudo);
////
////		if(c != null & cm != null)
////		{
////			int id_manager = cm.getId();
////			int id_joueur = c.getId();
////			daoO.delete(id_joueur,id_manager);
////		}
//	}
//
//	public static void afficheOffreByPseudos(String user)
//	{
//		String pseudo = saisieString("Saisir le pseudo du joueur li� � l'offre que vous voulez afficher");
//
//		IDAOOffre daoO = Application.getInstance().getDaoO();
//		IDAOCompte daoC = Application.getInstance().getDaoC();
//
//		Compte cm = daoC.selectByPseudo(user);
//		Compte c = daoC.selectByPseudo(pseudo);
//
//		if(c != null & cm != null)
//		{
//			int id_manager = cm.getId();
//			int id_joueur = c.getId();
//			Offre o = daoO.selectOffreByIds(id_joueur,id_manager);
//			System.out.println(o);
//		}
//		else
//		{
//			System.out.println("L'offre ne semble pas exister");
//		}
//
//	}
//
//
//	public Compte checkConnect(String login,String password)
//	{
//		DAOCompteJDBC daoC= new DAOCompteJDBC();
//		Compte c=daoC.checkConnect(login, password);	
//		return c;
//	}
//
//}
