package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOCompte;
import model.Application;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Roles;

public class DAOCompteJDBC implements IDAOCompte {

	@Override
	public void insert(Compte c) {
		
		try 
		(
			Connection connect=Application.getInstance().getConnection();
			PreparedStatement ps=connect.prepareStatement("INSERT INTO compte (login,password,typeCompte,nom,prenom,pseudo,equipe,role,salmin,elimination,mort,assist,kda) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
		)
		{
			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			ps.setString(3,c.getTypeCompte());
			ps.setString(4,c.getNom());
			ps.setString(5, c.getPrenom());
			ps.setString(6,c.getPseudo());
			ps.setString(7,c.getEquipe());
			
			if (c.getTypeCompte().contentEquals("joueur"))
			{
				ps.setString(8 ,((Joueur) c).getRole());
				ps.setDouble(9 ,((Joueur) c).getSalmin());
				ps.setDouble(10 ,((Joueur) c).getElimination());
				ps.setDouble(11 ,((Joueur) c).getMort());
				ps.setDouble(12 ,((Joueur) c).getAssist());
				ps.setDouble(13 ,((Joueur) c).getKda());
			}
			else
			{
				ps.setString(8 ,"");
				ps.setDouble(9 ,0);
				ps.setDouble(10 ,0);
				ps.setDouble(11 ,0);
				ps.setDouble(12 ,0);
				ps.setDouble(13 ,0);
			}

			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
		
	}

	@Override
	public Compte selectById(Integer id) {

        Compte c=null;
        try
        (
                Connection connect=Application.getInstance().getConnection();
                PreparedStatement ps=connect.prepareStatement("SELECT * from compte where id=?"); 
                )
        {
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) 
            {
            	 if(rs.getString("typeCompte").equals("joueur")) 
	             {
	                    c=new Joueur (rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"), rs.getString("role"), rs.getDouble("salmin"), rs.getDouble("elimination"), rs.getDouble("mort"), rs.getDouble("assist"));
	             }
	             else if(rs.getString("typeCompte").equals("manager")) 
	             {
	                    c=new Manager(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"));
	             }
            }
        }catch (Exception e) {e.printStackTrace();}

        return c;


    }
	
	@Override
	public List<Compte> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateSalmin(Compte c, double newSalmin) {
			try 
			(
				Connection connect=Application.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("UPDATE compte SET salmin = ? WHERE id = ?"); 
			)
			{
				ps.setDouble(1, newSalmin);
				ps.setInt(2, c.getId());
				ps.executeUpdate();

			}catch (Exception e) {e.printStackTrace();}
			
		}
		
	public void updateRole(Compte c, String newRole) {
		try 
		(
			Connection connect=Application.getInstance().getConnection();
			PreparedStatement ps=connect.prepareStatement("UPDATE compte SET role = ? WHERE id = ?"); 
		)
		{
			ps.setString(1, newRole);
			ps.setInt(2, c.getId());
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
		
	}

	@Override
	public void delete(Integer id) {
		try 
		(
			Connection connect=Application.getInstance().getConnection();
			PreparedStatement ps=connect.prepareStatement("DELETE FROM compte WHERE id = ?"); 
		)
		{
			ps.setInt(1, id);
			ps.executeUpdate();

		}catch (Exception e) {e.printStackTrace();}
		
	}
	
	public Compte checkConnect(String login,String password) 
	{
		Compte c=null;
		try
		(
				Connection connect=Application.getInstance().getConnection();
				PreparedStatement ps=connect.prepareStatement("SELECT * from compte where login=? and password=?"); 
		)
		{
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) 
			{
				 if(rs.getString("typeCompte").equals("joueur")) 
	             {
	                    c=new Joueur (rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"), rs.getString("role"), rs.getDouble("salmin"), rs.getDouble("elimination"), rs.getDouble("mort"), rs.getDouble("assist"));
	             }
	             else if(rs.getString("typeCompte").equals("manager")) 
	             {
	                    c=new Manager(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"));
	             }

			}
		}catch (Exception e) {e.printStackTrace();}

		return c;
	}

	public Compte selectByPseudo(String pseudo) {

        Compte c=null;
        try
        (
                Connection connect=Application.getInstance().getConnection();
                PreparedStatement ps=connect.prepareStatement("SELECT * from compte where pseudo=?"); 
         )
        {
            ps.setString(1, pseudo);
            ResultSet rs= ps.executeQuery();
           
            while(rs.next()) 
            {
            	 if(rs.getString("typeCompte").equals("joueur")) 
	             {
	                 c=new Joueur(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"), rs.getString("role"), rs.getDouble("salmin"), rs.getDouble("elimination"), rs.getDouble("mort"), rs.getDouble("assist"));
	             }
	             else if(rs.getString("typeCompte").equals("manager")) 
	             {
	                 c=new Manager(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"));
	             }
            }
        }catch (Exception e) {e.printStackTrace();}

        return c;

    }
	
	public Compte selectByLogin(String login) {

        Compte c=null;
        try
        (
                Connection connect=Application.getInstance().getConnection();
                PreparedStatement ps=connect.prepareStatement("SELECT * from compte where login=?"); 
         )
        {
            ps.setString(1, login);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) 
            {
                 if(rs.getString("typeCompte").equals("joueur")) 
                 {
                     c=new Joueur(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"), rs.getString("role"), rs.getDouble("salmin"), rs.getDouble("elimination"), rs.getDouble("mort"), rs.getDouble("assist"));
                 }
                 else if(rs.getString("typeCompte").equals("manager")) 
                 {
                     c=new Manager(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("pseudo"), rs.getString("equipe"));
                 }
            }
        }catch (Exception e) {e.printStackTrace();}

        return c;

    }

	@Override
	public void update(Compte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRole(Joueur j, String newRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalmin(Joueur j, double newSalmin) {
		// TODO Auto-generated method stub
		
	}


}
