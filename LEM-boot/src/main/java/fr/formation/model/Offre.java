package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="offre")
public class Offre {

	//Attributs
	@Id//OBLIGATOIRE
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincrement
	@Column(name="id")
	private int id;
	@ManyToOne()
	@JoinColumn(name="id_joueur")
	private Joueur joueur;
	@ManyToOne()
	@JoinColumn(name="id_manager")
	private Manager manager;
	@Column(name="salairePropose",nullable=false)
	private double salairePropose;
	@Column(name="equipePropose", length=25,nullable=false)
	private String equipePropose;
	@Column(name="rolePropose", length=25,nullable=false)
	private String rolePropose;
	
	//Constructeurs
	public Offre(Joueur joueur, Manager manager, double salairePropose, String equipePropose,
			String rolePropose) {
		
		this.joueur = joueur;
		this.manager = manager;
		this.salairePropose = salairePropose;
		this.equipePropose = equipePropose;
		this.rolePropose = rolePropose;
	}
	
	public Offre() {}
	
	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	///Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_joueur() {
		return 0;
	}

	public void setId_joueur(int id_joueur) {
	}

	public int getId_manager() {
		return 0;
	}

	public void setId_manager(int id_manager) {
	}

	public double getSalairePropose() {
		return salairePropose;
	}

	public void setSalairePropose(double salairePropose) {
		this.salairePropose = salairePropose;
	}

	public String getEquipePropose() {
		return equipePropose;
	}

	public void setEquipePropose(String equipePropose) {
		this.equipePropose = equipePropose;
	}

	public String getRolePropose() {
		return rolePropose;
	}

	public void setRolePropose(String rolePropose) {
		this.rolePropose = rolePropose;
	}

	@Override
	public String toString() {
		return "Offre [id=" + id + ", id_joueur=" + 0 + ", id_manager=" + 0 + ", salairePropose="
				+ salairePropose + ", equipePropose=" + equipePropose + ", rolePropose=" + rolePropose + "]";
	}
	

	
	
}
