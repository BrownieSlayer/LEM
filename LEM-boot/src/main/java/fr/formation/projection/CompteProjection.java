package fr.formation.projection;

import java.time.LocalDate;

import org.springframework.data.rest.core.config.Projection;

import fr.formation.model.Compte;
import fr.formation.model.Joueur;
import fr.formation.model.Manager;

@Projection(name = "compteProjection", types = { Compte.class, Manager.class, Joueur.class })
public interface CompteProjection {
	public int getId();
	public String getLogin();
}