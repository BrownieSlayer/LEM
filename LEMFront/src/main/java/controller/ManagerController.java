package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dao.IDAOCandidature;
import dao.IDAOCompte;
import dao.IDAOOffre;
import model.Compte;
import model.Offre;

@Controller
public class ManagerController {
	@Autowired
	private IDAOCompte daoCompte;
	@Autowired
	private IDAOOffre daoOffre;
	@Autowired
	private IDAOCandidature daoCandidature;
	
	
	@GetMapping("/manager")
	public String findAll(Model model, HttpSession session) {
		Compte compte=((Compte)session.getAttribute("compte"));
		model.addAttribute("compte", compte);
		model.addAttribute("joueurs", this.daoCompte.selectAllJoueurs());
		model.addAttribute("offres", this.daoOffre.selectOffresById(compte.getId()));
		model.addAttribute("candidatures", this.daoCandidature.selectCandidaturesById(compte.getId()));
		return "manager";
	}
	
	//Supprimer une offre
	@GetMapping("/manager/{id}/supprimerOffre")
	public String deleteById(@PathVariable int id) {
		try {
			this.daoOffre.deleteById(id);
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/manager";
	}
	
	//Proposer/Editer une offre
	@PostMapping("/manager")
	public String add(Offre offre) {	
		this.daoOffre.save(offre);	
		return "redirect:/manager";
	}
}