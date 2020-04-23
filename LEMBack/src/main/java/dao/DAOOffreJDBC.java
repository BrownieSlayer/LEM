package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Application;
import model.Compte;
import model.Joueur;
import model.Manager;
import model.Offre;

public class DAOOffreJDBC implements DAOOffre {

    @Override
    public void insert(Offre o) {
        try 
        (
                Connection connect=Application.getInstance().getConnection();
                PreparedStatement ps=connect.prepareStatement("INSERT INTO offre (id_joueur,id_manager,salairePropose,equipePropose,rolePropose) VALUES (?,?,?,?,?)"); 
        )
        {
            ps.setInt(1, o.getId_joueur());
            ps.setInt(2, o.getId_manager());
            ps.setDouble(3, o.getSalairePropose());
            ps.setString(4, o.getEquipePropose());
            ps.setString(5, o.getRolePropose());

            ps.executeUpdate();

        }catch (Exception e) {e.printStackTrace();}

    }
@Override
    public Offre selectById(Integer id) {

        Offre o =null;
        try
        (
                Connection connect=Application.getInstance().getConnection();
                PreparedStatement ps=connect.prepareStatement("SELECT * from offre where id=?"); 
                )
        {
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) 
            {
                //o=new Offre(rs.getInt("id_joueur"), rs.getInt("id_manager"), rs.getDouble("salairePropose"), rs.getString("equipePropose"), rs.getString("rolePropose"));
            }
        }catch (Exception e) {e.printStackTrace();}

        return o;

    }

	public Offre selectOffreByIds(Integer id_joueur, Integer id_manager) {

    Offre o =null;
    try
    (
            Connection connect=Application.getInstance().getConnection();
            PreparedStatement ps=connect.prepareStatement("SELECT * from offre where id_joueur=? and id_manager=?"); 
            )
    {
        ps.setInt(1, id_joueur);
        ps.setInt(2, id_manager);
        ResultSet rs= ps.executeQuery();
        while(rs.next()) 
        {
            //o=new Offre(rs.getInt("id_joueur"), rs.getInt("id_manager"), rs.getDouble("salairePropose"), rs.getString("equipePropose"), rs.getString("rolePropose"));
        }
    }catch (Exception e) {e.printStackTrace();}

    return o;

}


    public List<Offre> selectAll(Integer id) {

         DAOOffreJDBC daoO = new DAOOffreJDBC();
            Offre o = daoO.selectById(id);

            List<Offre> offre = new ArrayList();

            try
            (
                Connection connect=Application.getInstance().getConnection();
                PreparedStatement ps=connect.prepareStatement("SELECT * FROM offre where id=?"); 
            )
            {
                ps.setInt(1, id);
                ResultSet rs= ps.executeQuery();
                while(rs.next()) 
                {
                    offre.add(o);
                }
            }catch (Exception e) {e.printStackTrace();}

            return offre;
    }
@Override
    public void update(Offre t) {

    }

    public void delete(Integer id_joueur, Integer id_manager) {

        try 
        (
                Connection connect=Application.getInstance().getConnection();
                PreparedStatement ps=connect.prepareStatement("DELETE FROM offre WHERE id_joueur =? and id_manager =?"); 
                )
        {
            ps.setInt(1, id_joueur);
            ps.setInt(2, id_manager);
            ps.executeUpdate();

        }catch (Exception e) {e.printStackTrace();}

    }

    @Override
    public List<Offre> selectAll() {


        return null;
    }
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
}