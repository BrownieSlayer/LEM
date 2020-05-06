package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dao.IDAOCandidature;
import dao.IDAOCompte;
import dao.IDAOOffre;
import model.Compte;



@Controller
public class JoueurController {
	@Autowired
	private IDAOCompte daoCompte;
	@Autowired
	private IDAOOffre daoOffre;
	@Autowired
	private IDAOCandidature daoCandidature;
	
	@GetMapping("/joueur")
	public String findAll(Model model, HttpSession session) {
		Compte compte=((Compte)session.getAttribute("compte"));
		model.addAttribute("offres", this.daoOffre.selectOffresById(compte.getId()));
		model.addAttribute("candidatures", this.daoCandidature.selectCandidaturesById(compte.getId()));
		return "joueur";
	}
	
	
	
//	
//	
//	
//	@GetMapping("/patient/{secu}")
//	public String findById(@PathVariable int secu, Model model) {
//		model.addAttribute("patient", this.daoPatient.findById(secu).orElse(new Patient()));
//		
//		return "form-patient";
//	}
//	
//	@PostMapping("/patient")
//	public String add( patient) {
//		this.daoCompte.save(patient);
//		
//		return "redirect:/patient";
//	}
//	
//
//	
//	@GetMapping("/patient/{secu}/supprimer")
//	public String deleteById(@PathVariable int secu) {
//		try {
//			this.daoPatient.deleteById(secu);
//		}
//		
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:/patient";
//	}
}