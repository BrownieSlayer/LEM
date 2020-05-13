package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Compte;
import fr.formation.model.Joueur;
import fr.formation.model.Manager;

public interface IDAOCompte extends JpaRepository<Compte, Integer>{
	
	@Query("select c from Compte c where c.login = ?1 and c.password = ?2")
	public Compte checkConnect(String login, String password);
	
	@Query("select c from Compte c where c.pseudo = ?1")
	public Compte selectByPseudo(String pseudo);
	
	@Query("select c from Compte c where c.login = ?1")
	public Compte selectByLogin(String login);
	
	// A supprimer? doublon de findById?
	@Query("select c from Compte c where c.id = ?1")
	public Compte selectById(Integer id);
	
	@Query("select c from Compte c where c.salmin <= ?1")
	public Compte selectByBudget(double budget);
	
	@Query("select c from Compte c where c.role = ?1")
	public Compte selectByRole(String role);
	
	@Query("select c from Compte c where c.kda >= ?1")
	public Compte selectByKda(int kda);
	
	//Selectionne tous les joueurs sans equipe
	@Query("select j from Joueur j where j.equipe = null")
	public List<Compte> selectAllWithoutTeam();
	
	//Donne tous les joueurs d'une meme equipe (pour le manager)
	@Query("select j from Joueur j where j.equipe =?1")
	public List<Compte> selectTeam();
	
	//Permet de renseigner le manager en donnant le nom de l'équipe lors de l'inscription (pour les joueurs)
	@Query("select m from Manager m where m.equipe=?1")
	public Manager linkManagerTeam(String team);
	
	//Permet de renseigner sur les joueurs l'id du manager qui vient de s'inscrire et de le rendre nul lorsqu'il se desinscrit
	@Query("select j from Joueur j where j.equipe=?1")
	public List<Joueur> ajoutManager(String equipe);
	
	//Selectionne tous les joueurs
	@Query("select j from Joueur j")
	public List<Joueur> selectAllJoueurs();
	
	//Selectionne tous les joueurs
	@Query("select j from Joueur j where j.role = ?1")
	public List<Joueur> selectJoueursByRole(String role);
	
	//Selectionne tous les joueurs
	@Query("select j from Joueur j where j.salmin = ?1")
	public List<Joueur> selectJoueursBySalmin(Double salmin);
	
	
}
