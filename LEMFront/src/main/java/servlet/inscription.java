package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompte;
import model.Application;
import model.Compte;
import model.Joueur;
import model.Manager;

	@WebServlet("/inscription")
	public class inscription extends HttpServlet {   

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);	
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String pseudo=request.getParameter("pseudo");
			String login=request.getParameter("login");
			String action=request.getParameter("action");
			
			
			DAOCompte daoC = Application.getInstance().getDaoC();
			Compte c = null;
			if(action.equals("checkPseudo")) 
			{
				c = daoC.selectByPseudo(pseudo);
				if(c==null) 
				{
					
					response.getWriter().print("Y");
					
				}
				else 
				{
					response.getWriter().print("N");
				}
			}
			else if(action.equals("checkLogin"))
			{
				c = daoC.selectByLogin(login);
				if(c==null) 
				{	
					response.getWriter().print("Y");	
				}
				else 
				{
					response.getWriter().print("N");
				}
			}
			else{	
				System.out.println("je suis rentré dans le else");
				if(c == null)
				{
					String typeCompte=request.getParameter("typeCompte");
					if (typeCompte.equals("manager"))
					{
						String password=request.getParameter("password");
						String nom=request.getParameter("nom");
						String prenom=request.getParameter("prenom");
						String equipe=request.getParameter("equipe");
						c=new Manager(login, password, nom, prenom, pseudo, equipe);
						daoC.insert(c);
					}
					else if(typeCompte.equals("joueur"))
					{
						String password=request.getParameter("password");
						String nom=request.getParameter("nom");
						String prenom=request.getParameter("prenom");
						String equipe=request.getParameter("equipe");
						String role=request.getParameter("role");
						Double salmin=Double.parseDouble(request.getParameter("salmin"));
						Double elimination=Double.parseDouble(request.getParameter("elimination"));
						Double mort=Double.parseDouble(request.getParameter("mort"));
						Double assist=Double.parseDouble(request.getParameter("assist"));
						c=new Joueur(login, password, nom, prenom, pseudo, equipe, role, salmin, elimination, mort, assist);
						daoC.insert(c);
					}
					this.getServletContext().getRequestDispatcher("/WEB-INF/connect.jsp").forward(request, response);
				}
			}
		}

	}

