package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String updateSalmin(HttpSession session,
			@RequestParam double salmin
			) {

		Joueur compte=((Joueur)session.getAttribute("compte"));
		Joueur j = (Joueur) daoCompte.findById(compte.getId()).get();
		j.setSalmin(salmin);
		daoCompte.save(j);

		session.setAttribute("compte", j);

		return "redirect:/joueur";
	}

	@PostMapping("/joueur/updateRole")
	public String updateRole(HttpSession session,
			@RequestParam String role
			) {

		Joueur compte=((Joueur)session.getAttribute("compte"));
		Joueur j = (Joueur) daoCompte.findById(compte.getId()).get();
		j.setRole(role);
		daoCompte.save(j);

		session.setAttribute("compte", j);

		return "redirect:/joueur";
	}


	@PostMapping("/joueur/updateStats")
	public String updateStats(HttpSession session,
			@RequestParam double elimination,
			@RequestParam double mort,
			@RequestParam double assist, 
			@RequestParam double kda) {

		Joueur compte=((Joueur)session.getAttribute("compte"));	
		Joueur j = (Joueur) daoCompte.findById(compte.getId()).get();
		j.setElimination(elimination);
		j.setMort(mort);
		j.setAssist(assist);
		j.setKda(kda);
		daoCompte.save(j);
		
		session.setAttribute("compte", j);

		return "redirect:/joueur";
	}



	@PostMapping("/joueur/delete")
	public String delete(
			@RequestParam ("id_offre") int idOffre) {

		daoOffre.deleteById(idOffre);

		return "redirect:/joueur";
	}

	
	
	 @GetMapping("/joueur/{id}/accepter")
     public String accepterOffre(@PathVariable int id, HttpSession session) {

		  try {
              Offre o = this.daoOffre.findById(id).get();
              Joueur j = (Joueur)this.daoCompte.findById(o.getJoueur().getId()).get();
              Manager m = (Manager)this.daoCompte.findById(o.getManager().getId()).get();
              j.setEquipe(o.getEquipePropose());
              j.setRole(o.getRolePropose());
              j.setManager(m);
              this.daoCompte.save(j);
              this.daoOffre.deleteById(id);
              session.setAttribute("compte", j);
          }
          catch (Exception e) {
              e.printStackTrace();
          }
		
		
		  
		return "redirect:/joueur";
	}
	 
	 @GetMapping("/joueur/{id}/refuser")
     public String refuserOffre(@PathVariable int id) {

		  try {
              this.daoOffre.deleteById(id);
           
          }
          catch (Exception e) {
              e.printStackTrace();
          }
		
		  
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