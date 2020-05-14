package fr.formation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOCandidature;
import fr.formation.dao.IDAOCompte;
import fr.formation.dao.IDAOOffre;
import fr.formation.model.Candidature;
import fr.formation.model.Compte;
import fr.formation.model.Joueur;
import fr.formation.model.Manager;
import fr.formation.model.Offre;



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
		Joueur compte=((Joueur)session.getAttribute("compte"));
		model.addAttribute("compte", compte);
		model.addAttribute("offres", this.daoOffre.selectOffresById(compte.getId()));
		model.addAttribute("candidatures", this.daoCandidature.selectCandidaturesById(compte.getId()));
		model.addAttribute("managers", this.daoCompte.selectAllManagers());
		
		return "joueur";
	}
	
	
	@PostMapping("/joueur/updateSalmin")
	public String updateSalmin(
			@RequestParam double salmin,
			HttpSession session)  {
		
		Compte compte=((Compte)session.getAttribute("compte"));
		
		Joueur j = (Joueur) daoCompte.findById(compte.getId()).get();
		j.setSalmin(salmin);
		daoCompte.save(j);
		session.setAttribute("compte", j);
		
		return "redirect:/joueur";
	}
	
	@PostMapping("/joueur/updateRole")
	public String updateRole(
			@RequestParam String role,
			HttpSession session) {
		
		Compte compte=((Compte)session.getAttribute("compte"));
		
		Joueur j = (Joueur) daoCompte.findById(compte.getId()).get();
		j.setRole(role);
		daoCompte.save(j);
		session.setAttribute("compte", j);
		
		return "redirect:/joueur";
	}
	
	
	@PostMapping("/joueur/updateStats")
	public String updateStats(
			HttpSession session,
			@RequestParam double elimination,
			@RequestParam double mort,
			@RequestParam double assist 
			) {
		
		double kda = (elimination + assist)/mort;
		
		Compte compte=((Compte)session.getAttribute("compte"));
	Joueur j = (Joueur) daoCompte.findById(compte.getId()).get();
	j.setElimination(elimination);
	j.setMort(mort);
	j.setAssist(assist);
	j.setKda(kda);
	daoCompte.save(j);
	session.setAttribute("compte", j);
	
	return "redirect:/joueur";
	}
	
	
	
	@GetMapping("/joueur/{id}/refuser")
	public String delete(@PathVariable int id) {
		
		daoOffre.deleteById(id);
		
		return "redirect:/joueur";
	}
	
	@GetMapping("/joueur/{id}/accepter")
	public String accepter(@PathVariable int id) {
		
		Offre o = this.daoOffre.findById(id).get();
		Joueur j = (Joueur)this.daoCompte.findById(o.getJoueur().getId()).get();
		Manager m = (Manager)this.daoCompte.findById(o.getManager().getId()).get();
		j.setEquipe(o.getEquipePropose());
		j.setRole(o.getRolePropose());
		j.setManager(m);
		this.daoCompte.save(j);
		this.daoOffre.deleteById(id);
		
		return "redirect:/joueur";
	}
	
	@PostMapping("/joueur/candidater")
	public String candidater(Candidature candidature, HttpSession session) {
			
			daoCandidature.save(candidature);
			
		return "redirect:/joueur";
	}
	
	//Supprimer une candidature
		@GetMapping("/joueur/{id}/supprimerCandidature")
		public String deleteCandidature(@PathVariable int id) {
			try {
				this.daoCandidature.deleteById(id);
			}	
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/joueur";
		}
		
		//Proposer/Editer une candidature
		@PostMapping("/joueur")
			public String add(Candidature c) {	
			this.daoCandidature.save(c);	
			return "redirect:/joueur";
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