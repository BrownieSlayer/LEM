package servlet;

	import java.util.List;
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import model.*;

	@WebServlet("/joueur")
	public class joueur extends springServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	

	        this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
	        
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        /*String role = request.getParameter("role");
	        Double salmin =Double.parseDouble(request.getParameter("salmin"));
	    	String pseudo = request.getParameter("pseudo");
	        Compte c = Application.getInstance().getDaoC().selectByPseudo(pseudo);
	        
	        if (actionRole)
	        {
	        Application.getInstance().getDaoC().updateRole(c, role);
	        }
	        else if (actionSalmin)
	        {
	        Application.getInstance().getDaoC().updateSalmin(c, salmin);
	        }*/
	    }

	}

