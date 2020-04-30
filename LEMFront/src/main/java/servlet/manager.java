package servlet;

	import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.ApplicationContext;
import model.Candidature;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Offre;

	@WebServlet("/manager")
	public class manager extends springServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		
	    	int idPage = Integer.parseInt(request.getParameter("id_page"));
	    
	    	Compte comptePage = daoCompte.selectById(idPage);
	    	request.getSession().setAttribute("id", idPage);
            request.getSession().setAttribute("login", comptePage.getLogin());
            request.getSession().setAttribute("nom", comptePage.getNom());
            request.getSession().setAttribute("prenom", comptePage.getPrenom());
            request.getSession().setAttribute("pseudo", comptePage.getPseudo());
            request.getSession().setAttribute("equipe", comptePage.getEquipe());
            List<Offre> offres = daoOffre.selectOffresById(idPage);   	
            request.setAttribute("offres", offres);    	
	    	
	        this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
	        
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	    	String option = request.getParameter("option");
	    	int idPage = Integer.parseInt(request.getParameter("id_page"));
	    	System.out.println(option);
	    	
	    	//Profil	        
	       	if(option.equals("updateSalmin"))
	        {
	       		Double salmin = Double.parseDouble(request.getParameter("salmin"));
	       		Joueur j = new Joueur();
	       		j.setId(idPage);
	       		j.setSalmin(salmin);
	       		daoCompte.save(j);
	        }
	        else if (option.equals("updateRole"))
	        {
	        	String role = request.getParameter("role");
	       		Joueur j = new Joueur();
	       		j.setId(idPage);
	       		j.setRole(role);
	       		System.out.println(j);
	       		daoCompte.save(j);
	        }
	    	//Offre
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
	    		daoOffre.save(o);
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
		        daoOffre.save(o);
	    	}
	    	else if(option.equals("delete"))
	    	{
		        int idOffre = Integer.parseInt(request.getParameter("id_offre"));
	    		daoOffre.deleteById(idOffre);
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
	    		daoOffre.deleteById(idOffre);
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
	    		daoCandidature.save(candidature);
	    		request.getSession().setAttribute("candReussi", 1);
	    		}
	    		request.getSession().setAttribute("candReussi", 0);
	    		
	    	}  	
	    	    	
	    	doGet(request, response);
	    }
 }

