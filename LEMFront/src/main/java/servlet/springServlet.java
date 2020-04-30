package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.IDAOCandidature;
import dao.IDAOCompte;
import dao.IDAOOffre;

public abstract class springServlet extends HttpServlet {

	@Autowired
	protected IDAOCompte daoCompte;
	
	@Autowired
	protected IDAOOffre daoOffre;
	
	@Autowired
	protected IDAOCandidature daoCandidature;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport. //On demande a spring de scan la classe 
		processInjectionBasedOnServletContext(this, config.getServletContext());
	}
}
