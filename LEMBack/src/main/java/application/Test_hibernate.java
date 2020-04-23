package application;

import dao.IDAOCompte;
import dao.IDAOOffre;
import dao.jpa.DAOJPA;
import model.Joueur;

public class Test_hibernate {
	public static void main(String[] args) {
		IDAOOffre daoOffre = ApplicationContext.getDaoOffre();
		IDAOCompte daoCompte = ApplicationContext.getDaoCompte();
		
		//Test insert
		/*Joueur joueur = new Joueur("Golden","mdp","Dudouit", "Thibault","Golden",null,null,"Mid",10000,5.0,2.0,5.0);
		daoCompte.insert(joueur);*/
		
		DAOJPA.close();
	}
}
