package application;

import java.util.Scanner;

import model.Application;
import model.Compte;

public class Test_App {
	
	///Attributs
	public static String user;

	
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
	
	public static void home() {
        int choix;
        System.out.println("Bienvenue sur LoL Esport Manager\n");
        System.out.println("1 - Se connecter");
        System.out.println("2 - S'inscrire");
        System.out.println("3 - Quitter");
        choix=saisieInt("Choisir une action (1/2/3)");

        switch(choix) 
        {
        case 1 : connect();break;
        case 2 : Application.addCompte();home(); break;
        case 3 : System.out.println("A bientôt :)");System.exit(0); break;
        default : home(); break;
        }
    }
public static void connect() {

        String login=saisieString("Saisir votre login");
        String password=saisieString("Saisir votre password");

        Compte c = Application.getInstance().checkConnect(login, password);

        if(c==null) {System.out.println("Identifiants invalides");home();}
        else {
        	user = c.getPseudo();
            switch(c.getTypeCompte()) {
            case "joueur" : menuJoueur();break;
            case "manager" : menuManager();break;
            }
        }
    }
public static void menuJoueur() {
        System.out.println("Menu Joueur \n");
        System.out.println("1 - Rechercher un joueur ou un manager");
        System.out.println("2 - Modifier ses informations");
        System.out.println("3-Visualiser les Offres reçues");
        System.out.println("4 - Supprimer compte");
        System.out.println("5 - Se deconnecter");
        int choix=saisieInt("Choisir un menu");

        switch(choix) 
        {
        case 1 : Application.afficheCompte();menuJoueur();break;
        case 2 : System.out.println(user);Application.afficheCompteUser(user);menuModifInfo();break;
        case 3 : menuJoueur();break;  //Visualiser ses offres 
        case 4 : menuJoueur();break;  //supprimer son compte joueur
        case 5 : user = ""; home() ;break;
        default : menuJoueur();break;
        }
    }
public static void menuGererOffre() {
    System.out.println("Que voulez-vous faire?");
    System.out.println("1 - Formuler une offre envers un joueur");
    System.out.println("2 - Voir la liste des propositions effectuées");
    System.out.println("3 - Supprimmer une offre");
    System.out.println("4 - Revenir à votre menu");
int choix=saisieInt("Choisir un menu");

    switch(choix) {
    case 1 : Application.addOffre(user);menuManager();break;
    case 2 : menuGererOffre();break; //Ajouter afficher liste des propositions faires
    case 3 : Application.deleteOffreManager(user);menuManager(); break; 
    case 4 : Application.deleteOffreManager(user);menuManager(); break;
    default : menuGererOffre();break;
    }
}
public static void menuManager() {

    System.out.println("Menu Manager \n");
    System.out.println("1 - Afficher la liste des joueurs");
    System.out.println("2 - Gerer les offres");
    System.out.println("3 - Virer joueur");
    System.out.println("4 - Se deconnecter");
    int choix=saisieInt("Choisir un menu");

    switch(choix) 
    {
    case 1 : Application.afficheCompte(); menuManager();break;
    case 2 : menuGererOffre();break;
    case 3 : menuManager();break;
    case 4 : user = "";home();break;
    default : menuManager();break;
    }
}
public static void menuModifInfo() {
        System.out.println("Quels informations voulez-vous modifier?\n");
        System.out.println("1 - Modifier son Poste");
        System.out.println("2 - Modifier son salaire minimum demandé");
        System.out.println("3 - Revenir à votre menu");
        
        int choix=saisieInt("Choisir un menu");
        
        switch(choix) {
        case 1 : Application.modifRoleJoueur(user);menuJoueur();break;
        case 2 : Application.modifSalaireJoueur(user);menuJoueur();break;
        case 3 : menuJoueur(); break;
        default : menuJoueur();break;
        }
    }
	
	public static void main(String[] args) {	
		
		Compte c = Application.getInstance().getDaoC().selectByLogin("Golden");
		System.out.println(c);
		
	}
}
