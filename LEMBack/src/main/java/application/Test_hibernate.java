package application;

import java.util.List;

import dao.IDAOCandidature;
import dao.IDAOCompte;
import dao.IDAOOffre;
import dao.jpa.DAOJPA;
import model.Candidature;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Offre;

public class Test_hibernate {
	public static void main(String[] args) {
		IDAOOffre daoOffre = ApplicationContext.getDaoOffre();
		IDAOCompte daoCompte = ApplicationContext.getDaoCompte();
		IDAOCandidature daoCandidature = ApplicationContext.getDaoCandidature();
		
		
		
		
		//Compte
		//Test insert Compte
		/*Joueur joueur = new Joueur("Golden","mdp","Dudouit", "Thibault","Golden",null,null,"Mid",10000,5.0,2.0,5.0);
		daoCompte.insert(joueur);*/
		
		//Test selectAll
		/*List <Compte> listCompte = daoCompte.selectAll();
		for (Compte c : listCompte)
		{
			System.out.println(c.getPseudo());
		}*/
		
		//Test selectById
		/*Joueur joueur = (Joueur) daoCompte.selectById(5);
		System.out.println(joueur);*/
		
		
		//Test update
		/*Joueur joueur = new Joueur("Golden","mdp","Dudouit", "Thibault","Golden",null,null,"Mid",10000,10,2.0,5.0);
		joueur.setId(13);
		daoCompte.update(joueur);*/
		
		
		//Test updateRole
		/*Joueur joueur = (Joueur) daoCompte.selectById(13);
		daoCompte.updateRole(joueur,"Top");*/
		
		//Test updateSalmin 
		/*Joueur joueur = (Joueur) daoCompte.selectById(13);
		daoCompte.updateSalmin(joueur,50000);*/
		
		//Test selectByPseudo
		/*Compte c = daoCompte.selectByPseudo("Caps");
		System.out.println(c.getPseudo());*/
		
		//Test selectByLogin
		/*Compte c = daoCompte.selectByLogin("Caps");
		System.out.println(c.getLogin());*/
		
		//Test CheckConnect
		/*Compte c  = daoCompte.checkConnect("Caps", "mdp");
		System.out.println(c.getPseudo());*/
		
		//Test Select Team
		Manager m = (Manager) daoCompte.selectByLogin("Grabbz");
		List<Compte> team = daoCompte.selectTeam(m);
		for (Compte c : team)
		{
			System.out.println(c.getPseudo());
		}
		
		
		///OFFRE OK
		//Test insert Offre
		/*Joueur joueur = (Joueur) daoCompte.selectById(13);
		Manager manager = (Manager) daoCompte.selectById(1); 
		Offre offre = new Offre(joueur, manager, 50000,"G2","Mid");
		daoOffre.insert(offre);*/
		
		//Test selectAll Offre
		/*List <Offre> listOffre = daoOffre.selectAll();
		for (Offre o : listOffre)
		{
			System.out.println(o.getEquipePropose());
		}*/
		
		//Test selectById
		/*Offre offre = daoOffre.selectById(1);
		System.out.println(offre);*/
		
		//Test update
		/*Offre offre = daoOffre.selectById(1);
		offre.setSalairePropose(100000);
		daoOffre.update(offre);*/
		
		//Test selectByComptes	
		/*List<Offre> offre = daoOffre.selectOffreByCompte(1);
		for (Offre o : offre)
		{
		System.out.println(o.getId());
		}*/
		
		
		//Test selectAll
		/*List<Offre> ListOffre = daoOffre.selectAll();
		for (Offre o : ListOffre)
		{
		System.out.println(o.getId());
		}*/
		
		//Test delete
		//daoOffre.delete(1);
		
		
		
		
		//Candidature
		//Test insert Candidature
				/*Joueur joueur = (Joueur) daoCompte.selectById(7);
				Manager manager = (Manager) daoCompte.selectById(1); 
				Candidature candidature = new Candidature(joueur, manager, 50000,"G2","Mid");
				daoCandidature.insert(candidature);*/
		
		/*Manager m = (Manager) daoCompte.selectById(1);
		for (Offre o : m.getOffreJoueur())
		{
			System.out.println(o.getJoueur());
		}*/
		
		
		DAOJPA.close();
	}
}
