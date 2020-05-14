package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOCompte;
import fr.formation.exception.CompteValidationException;
import fr.formation.model.Compte;
import fr.formation.projection.Views;

@RestController // Ce controller ne renverra aucune vue HTML
//@CrossOrigin"*") //Si jamais on a besoin d'interroger un autre domaine
@RequestMapping("/api/compte")
public class CompteApiController {
	@Autowired
	private IDAOCompte daoCompte;
		
		//Liste des Comptes @GET
		@GetMapping
		@JsonView(Views.Compte.class)
		public List<Compte> findByAll() {
			return this.daoCompte.findAll();
		}
		
		//Une Compte @GET
		@GetMapping("/{id}")
		@JsonView(Views.Compte.class)
		public Compte findById(@PathVariable int id) {
			
			return this.daoCompte
					.findById(id)
					.orElse(new Compte());
		}
		
		//Ajouter une Compte : @POST
		@PostMapping
		@JsonView(Views.Compte.class)
		public Compte add(@Valid @RequestBody Compte Compte, BindingResult result)
		{		
			if (result.hasErrors()) {
				throw new CompteValidationException();
			}
			this.daoCompte.save(Compte);
			return Compte;
		}
		
		//Modifier une Compte : @PUT
		@PutMapping("/{id}")
		@JsonView(Views.Compte.class)
		public Compte update(@PathVariable int id, @RequestBody Compte Compte) {
			Compte.setId(id);
			this.daoCompte.save(Compte);
			return new Compte();
		}
		
		//Supprimer une Compte : @DELETE
		@DeleteMapping("/{id}")
		@JsonView(Views.Compte.class)
		public boolean delete(@PathVariable int id) {
			try {
				this.daoCompte.deleteById(id);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
			
		}
}
