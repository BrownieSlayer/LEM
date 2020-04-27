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
	public class offre extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String option = request.getParameter("option");
	    	
	    	Compte c = ApplicationContext.getDaoCompte().checkConnect("Kodo","mdp");
	    	
	    	//dao qui va chercher toutes les équipes
	    	Hibernate.initialize(((Joueur) c).getOffres());
	    	List<Offre> offres = ((Joueur) c).getOffres();
            request.setAttribute("offres", offres);
	    	
            //Forcer a nettoyer le cache de EntityManager
            ApplicationContext.getDaoCompte().detach(c);
            
	    	//Faut donner cette liste à la vue JSP
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/offre.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	               
	    	String option = request.getParameter("option");
	    	
	    	System.out.println(option);
	    	
	    	if(option.equals("insert"))
	    	{
	    		int idJoueur = Integer.parseInt(request.getParameter("id_joueur"));
	    		int idManager = Integer.parseInt(request.getParameter("id_manager"));
	    		String rolePropose = request.getParameter("role");
	    		Double salairePropose = Double.parseDouble(request.getParameter("salmin"));
	    		Manager m = (Manager) ApplicationContext.getDaoCompte().selectById(idManager);
	    		Joueur j = (Joueur) ApplicationContext.getDaoCompte().selectById(idManager);
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
		        ApplicationContext.getDaoOffre().update(o);
	    	}
	    	else if(option.equals("delete"))
	    	{
		        int idOffre = Integer.parseInt(request.getParameter("id_offre"));
	    		ApplicationContext.getDaoOffre().delete(idOffre);
	    	}
	    	else if (option.equals("accepter"))
	    	{
	    		int idOffre = Integer.parseInt(request.getParameter("id_offre"));
	    		int idJoueur = Integer.parseInt(request.getParameter("id_joueur"));
	    		int idManager = Integer.parseInt(request.getParameter("id_manager"));
	    		Manager manager = (Manager) ApplicationContext.getDaoCompte().selectById(idManager);
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
	    		ApplicationContext.getDaoCompte().update(joueur);
	    		ApplicationContext.getDaoOffre().delete(idOffre);
	    	}
	    	
	    	doGet(request, response);
	    }

	}



