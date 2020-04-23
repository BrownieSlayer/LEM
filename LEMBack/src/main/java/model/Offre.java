package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="offre")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="id")
public class Offre {

	//Attributs
	@Id//OBLIGATOIRE
//	@GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincrement
	
	protected static int nb_offre = 0;
	@Column(name="id")
	private int id;
	@Column(name="id_joueur", length=25,nullable=false)
	private int id_joueur;
	@Column(name="id_manager", length=25,nullable=false)
	private int id_manager;
	@Column(name="salairePropose", length=25,nullable=false)
	private double salairePropose;
	@Column(name="equipePropose", length=25,nullable=false)
	private String equipePropose;
	@Column(name="rolePropose", length=25,nullable=false)
	private String rolePropose;
	
	//Constructeurs
	public Offre(int id_joueur, int id_manager, double salairePropose, String equipePropose,
			String rolePropose) {
		
		nb_offre += 1;
		this.id = nb_offre;
		this.id_joueur = id_joueur;
		this.id_manager = id_manager;
		this.salairePropose = salairePropose;
		this.equipePropose = equipePropose;
		this.rolePropose = rolePropose;
	}
	
	///Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public int getId_manager() {
		return id_manager;
	}

	public void setId_manager(int id_manager) {
		this.id_manager = id_manager;
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
		return "Offre [id=" + id + ", id_joueur=" + id_joueur + ", id_manager=" + id_manager + ", salairePropose="
				+ salairePropose + ", equipePropose=" + equipePropose + ", rolePropose=" + rolePropose + "]";
	}
	

	
	
}
