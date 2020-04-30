package servlet;

	import java.util.Arrays;
import java.util.List;
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import application.ApplicationContext;
import model.*;

	@WebServlet("/offre")
	public class offre extends springServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String option = request.getParameter("option");
	    	
	    	Compte c = daoCompte.checkConnect("Kodo","mdp");
	    	int idCompte = c.getId();
	    	//dao qui va chercher toutes les équipes
	    	List<Offre> offres = daoOffre.selectOffresById(idCompte);
            request.setAttribute("offres", offres);
            
	    	//Faut donner cette liste à la vue JSP
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/offre.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	               
	    	//Offre
	    	String option = request.getParameter("option");
	    	
	    	System.out.println(option);
	    	
	    	if(option.equals("insert"))
	    	{
	    		int idJoueur = Integer.parseInt(request.getParameter("id_joueur"));
	    		int idManager = Integer.parseInt(request.getParameter("id_manager"));
	    		String rolePropose = request.getParameter("role");
	    		Double salairePropose = Double.parseDouble(request.getParameter("salmin"));
	    		Manager m = (Manager) daoCompte.selectById(idManager);
	    		Joueur j = (Joueur) daoCompte.selectById(idManager);
	    		String equipePropose = m.getEquipe();
	    		Offre o = new Offre(j,m,salairePropose,rolePropose,equipePropose);
	    		ApplicationContext.getDaoOffre().insert(o);
	    	}
	    	else if (option.equals("update"))
	    	{
		    	String rolePropose = request.getParameter("role");
		        Double salairePropose = Double.parseDouble(request.getParameter("salmin"));
		        int idOffre = Integer.parseInt(request.getParameter("id"));
		        
		        Offre o = new Offre();
		        o.setId(idOffre);
		        o.setSalairePropose(salairePropose);
		        o.setRolePropose(rolePropose);
		        ApplicationContext.getDaoOffre().save(o);
	    	}
	    	else if(option.equals("delete"))
	    	{
		        int idOffre = Integer.parseInt(request.getParameter("id_offre"));
	    		ApplicationContext.getDaoOffre().deleteById(idOffre);
	    	}
	    	else if (option.equals("accepter"))
	    	{
	    		int idOffre = Integer.parseInt(request.getParameter("id_offre"));
	    		int idJoueur = Integer.parseInt(request.getParameter("id_joueur"));
	    		int idManager = Integer.parseInt(request.getParameter("id_manager"));
	    		Manager manager = (Manager) daoCompte.selectById(idManager);
	    		String equipe = request.getParameter("equipe");
	    		String role= request.getParameter("role");
	    		System.out.println(idJoueur);
	    		System.out.println(idManager);
	    		System.out.println(equipe);
	    		System.out.println(role);
	    		Joueur joueur = new Joueur();
	    		joueur.setId(idJoueur);
	    		joueur.setEquipe(equipe);
	    		joueur.setRole(role);
	    		joueur.setManager(manager);
	    		daoCompte.save(joueur);
	    		ApplicationContext.getDaoOffre().deleteById(idOffre);
	    	}
	    	else if (option.equals("candidater"))
	    	{
	    		System.out.println("candidature");
	    		//int idJoueur = Integer.parseInt(request.getParameter("id_joueur"));
	    		int idJoueur = 7;
	    		String pseudoManager = request.getParameter("pseudo_manager");
	    		
	    		Manager manager = (Manager) daoCompte.selectByPseudo(pseudoManager);
	    			System.out.println(manager.getPseudo());
	    		if (manager != null)
	    		{
	    		Joueur joueur = (Joueur) daoCompte.selectById(idJoueur);
	    			System.out.println(joueur);
	    		String roleDemande = request.getParameter("role_demande");
	    			System.out.println(roleDemande);
	    		String equipeDemande = manager.getEquipe();
	    			System.out.println(equipeDemande);
	    		Double salaireDemande = Double.parseDouble(request.getParameter("salaire_demande"));
	    			System.out.println(salaireDemande);
	    		Candidature candidature = new Candidature();
	    			System.out.println(candidature);
	    		candidature.setJoueur(joueur);
	    		candidature.setManager(manager);
	    		candidature.setSalaireDemande(salaireDemande);
	    		candidature.setEquipeDemande(equipeDemande);
	    		candidature.setRoleDemande(roleDemande);
	    		ApplicationContext.getDaoCandidature().insert(candidature);
	    		request.getSession().setAttribute("candReussi", 1);
	    		}
	    		request.getSession().setAttribute("candReussi", 0);
	    	}
	    	
	    	doGet(request, response);
	    }

	}



