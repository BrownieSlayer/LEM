package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IDAOCandidature;
import dao.IDAOCompte;
import dao.IDAOOffre;
import model.Compte;
import model.Joueur;
import model.Manager;

@Controller
//@RequestMapping("/home") // PREFIXER TOUS LES MAPPINGS DE CETTE CLASSE
public class HomeController {
	@Autowired
	private IDAOCompte daoCompte;
	@Autowired
	private IDAOOffre daoOffre;
	@Autowired
	private IDAOCandidature daoCandidature;
	
	@GetMapping({ "/", "/connect" })
	public String connect(Model model) {
		return "connect";
	}
	
	
	@PostMapping("/connect")
	public String connect(
			@RequestParam(value = "login") String username,
			@RequestParam String password,
			HttpSession session, Model model) {
		
		if (username.isEmpty()) {
			model.addAttribute("error", "Username must not be empty");
			return "connect";
		}
		
		//On v�rifie la connexion
		Compte compte = this.daoCompte.checkConnect(username, password);
		
		if (compte == null) {
			model.addAttribute("error", "Login incorrect");
			return "connect";
		}

		if (compte instanceof Joueur) {
			session.setAttribute("compte", compte);
			return "redirect:/joueur";
		}
		else if (compte instanceof Manager) {
			session.setAttribute("compte", compte);
			model.addAttribute("offres", this.daoOffre.selectOffresById(compte.getId()));
			model.addAttribute("candidatures", this.daoCandidature.selectCandidaturesById(compte.getId()));
			return "redirect:/manager";
		}
		else {
			return "redirect:/connect";
		}
	}
	
}