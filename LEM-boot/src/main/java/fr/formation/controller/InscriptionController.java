package fr.formation.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.formation.dao.IDAOCandidature;
import fr.formation.dao.IDAOCompte;
import fr.formation.dao.IDAOOffre;
import fr.formation.model.Compte;
import fr.formation.model.Joueur;
import fr.formation.model.Manager;

@Controller
//@RequestMapping("/home") // PREFIXER TOUS LES MAPPINGS DE CETTE CLASSE
public class InscriptionController {
	@Autowired
	private IDAOCompte daoCompte;
	@Autowired
	private IDAOOffre daoOffre;
	@Autowired
	private IDAOCandidature daoCandidature;


	@GetMapping({ "/inscription" })
	public String inscription(Model model) {
		return "inscription";
	}

	@PostMapping("/inscription")
	public String inscriptionJoueur(
			Compte compte,
			@RequestParam String role, //Attributs qui ne sont pas dans compte
			@RequestParam(required = false) Double salmin,
			@RequestParam(required = false) Double elimination,
			@RequestParam(required = false) Double mort,
			@RequestParam(required = false) Double assist,
			Model model) {


		if (compte.getTypeCompte().equals("Manager"))
		{
			compte=new Manager(compte);
			daoCompte.save(compte);

			//Ajoute le manager sur tous les joueur de son equipe deja inscrit dans la base
			List<Joueur> saTeam = daoCompte.ajoutManager(compte.getEquipe());
			for (Joueur j : saTeam ) {
				j.setManager((Manager) compte);
				daoCompte.save(j);
			}
		}
		else if(compte.getTypeCompte().equals("Joueur"))
		{
			//Ajoute le manager qui gere l'equipe avec lequel il s'inscrit
			Manager manager = daoCompte.linkManagerTeam(compte.getEquipe());

			compte=new Joueur(compte, manager, role, salmin, elimination, mort, assist);
			this.daoCompte.save(compte);
		}
		return "connect";
	}
	
	


	@PostMapping("/inscription/checkPseudo")
	@ResponseBody
	public String verifPseudo(@RequestParam String pseudo) {

		Compte compte = daoCompte.selectByPseudo(pseudo);
		if (compte == null) {

			return "Y";

		} else {
			return "N";
		}
	}
	
	
	@PostMapping("/inscription/checkLogin")
	@ResponseBody
	public String verifLogin(@RequestParam String login) {

		Compte compte = daoCompte.selectByLogin(login);
		if (compte == null) {

			return "Y";

		} else {
			return "N";
		}
	}

}

