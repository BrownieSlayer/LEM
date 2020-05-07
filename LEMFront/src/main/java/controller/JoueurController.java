package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IDAOCandidature;
import dao.IDAOCompte;
import dao.IDAOOffre;
import model.Candidature;
import model.Joueur;
import model.Manager;
import model.Offre;



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
		
		return "joueur";
	}
	
	
	@PostMapping("/joueur/updateSalmin")
	public String updateSalmin(
			@RequestParam double salmin,
			@RequestParam ("id_page") int idPage) {
		
		Joueur j = (Joueur) daoCompte.findById(idPage).get();
		j.setSalmin(salmin);
		daoCompte.save(j);
		
		return "redirect:/joueur";
	}
	
	@PostMapping("/joueur/updateRole")
	public String updateRole(
			@RequestParam String role,
			@RequestParam ("id_page") int idPage) {
		
		Joueur j = (Joueur) daoCompte.findById(idPage).get();
		j.setRole(role);
		daoCompte.save(j);
		
		return "redirect:/joueur";
	}
	
	
	@PostMapping("/joueur/updateStats")
	public String updateStats(
			@RequestParam ("id_page") int idPage,
			@RequestParam double elimination,
			@RequestParam double mort,
			@RequestParam double assist, 
			@RequestParam double kda) {
	Joueur j = (Joueur) daoCompte.findById(idPage).get();
	j.setElimination(elimination);
	j.setMort(mort);
	j.setAssist(assist);
	j.setKda(kda);
	daoCompte.save(j);
	
	return "redirect:/joueur";
	}
	
	
	
	@PostMapping("/joueur/delete")
	public String delete(
			@RequestParam ("id_offre") int idOffre) {
		
		daoOffre.deleteById(idOffre);
		
		return "redirect:/joueur";
	}
	
	@PostMapping("/joueur/accepter")
	public String accepter(
			@RequestParam("id_page") int idPage,
			@RequestParam("id_offre") int idOffre,
			@RequestParam("id_joueur") int idJoueur,
			@RequestParam("id_manager") int idManager,
			@RequestParam String equipe,
			@RequestParam String role) {
		
		Manager manager = (Manager) daoCompte.selectById(idManager);
		
		System.out.println(idJoueur);
		System.out.println(idManager);
		System.out.println(equipe);
		System.out.println(role);
		
		Joueur j = (Joueur) daoCompte.findById(idPage).get();
		j.setEquipe(equipe);
		j.setRole(role);
		j.setManager(manager);
		daoCompte.save(j);
		daoOffre.deleteById(idOffre);
		
		return "redirect:/joueur";
	}
	
	@PostMapping("/joueur/candidater")
	public String candidater(
			@RequestParam ("id_joueur") int idJoueur,
			@RequestParam ("pseudo_manager") String pseudoManager,
			@RequestParam ("role_demande") String roleDemande,
			@RequestParam("salaire_demande") double salaireDemande,
			HttpSession session) {
		
		System.out.println("candidature");

		Manager manager = (Manager) daoCompte.selectByPseudo(pseudoManager);
		System.out.println(manager.getPseudo());
		if (manager != null)
		{
			Joueur joueur = (Joueur) daoCompte.selectById(idJoueur);
			System.out.println(joueur);
			System.out.println(roleDemande);
			String equipeDemande = manager.getEquipe();
			System.out.println(equipeDemande);
			System.out.println(salaireDemande);
			Candidature candidature = new Candidature();
			System.out.println(candidature);
			candidature.setJoueur(joueur);
			candidature.setManager(manager);
			candidature.setSalaireDemande(salaireDemande);
			candidature.setEquipeDemande(equipeDemande);
			candidature.setRoleDemande(roleDemande);
			daoCandidature.save(candidature);
			session.setAttribute("candReussi", 1);
		}
		session.setAttribute("candReussi", 0);
		
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