package dao.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOOffre;
import model.Application;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Offre;

public class DAOOffreJPA implements IDAOOffre {

	@Override
	public void insert(Offre t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Offre selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offre> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Offre t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Offre selectOffreByIds(Integer id_joueur, Integer id_manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offre> selectAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id_joueur, Integer id_manager) {
		// TODO Auto-generated method stub
		
	}

}