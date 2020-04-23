package servlet;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

@WebServlet("/connect")
public class connect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	

        this.getServletContext().getRequestDispatcher("/WEB-INF/connect.jsp").forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Compte c = Application.getInstance().getDaoC().checkConnect(login,password);
        request.setAttribute("erreur", "");
        
        if (c instanceof Joueur) 
        {
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("nom", c.getNom());
            request.getSession().setAttribute("prenom", c.getPrenom());
            request.getSession().setAttribute("pseudo", c.getPseudo());
            request.getSession().setAttribute("elimination", ((Joueur) c).getElimination());
            request.getSession().setAttribute("mort", ((Joueur) c).getMort());
            request.getSession().setAttribute("assist", ((Joueur) c).getAssist());
            request.getSession().setAttribute("kda", ((Joueur) c).getKda());
            request.getSession().setAttribute("role", ((Joueur) c).getRole());
            request.getSession().setAttribute("salmin", ((Joueur) c).getSalmin());
            request.getSession().setAttribute("equipe", c.getEquipe());
            request.getSession().setAttribute("isConnect", "Y");
            this.getServletContext().getRequestDispatcher("/WEB-INF/joueur.jsp").forward(request, response);
        }
        else if (c instanceof Manager) 
        {
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("isConnect", "Y");
            request.getSession().setAttribute("nom", c.getNom());
            request.getSession().setAttribute("prenom", c.getPrenom());
            request.getSession().setAttribute("pseudo", c.getPseudo());
            request.getSession().setAttribute("equipe", c.getEquipe());
            this.getServletContext().getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
        }
        else {
            request.getSession().setAttribute("isConnect", "N");
            request.setAttribute("erreur", "Login et / ou password invalides");
            doGet(request, response);
        }



    }

}