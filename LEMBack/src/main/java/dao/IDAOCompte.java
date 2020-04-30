package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Compte;
import model.Manager;

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
	@Query("select c from Compte c where c.equipe = null")
	public List<Compte> selectAllWithoutTeam();
	
	//Donne tous les joueurs d'une meme equipe (pour le manager)
	@Query("select c from Compte c where c.typeCompte =Joueur and c.equipe =?1")
	public List<Compte> selectTeam();
	
	//Permet de renseigner le manager en donnant le nom de l'équipe lors de l'inscription
	@Query("select m from Manager m where m.equipe=?1")
	public Manager linkManagerTeam(String team);
	
	
	
	
	
}
