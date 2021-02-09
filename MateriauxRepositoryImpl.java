package repository;


import core.DataSourceProvider;
import core.entity.Materiaux;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriauxRepositoryImpl {

    public MateriauxRepositoryImpl() {
    }

	public Materiaux getByNom(String nom){
        Connection conn=null;
        Materiaux materiaux=null;
        try {
            
           DataSource dataSource= DataSourceProvider.getSingleDataSourceInstance();

           conn=dataSource.getConnection();
           
           PreparedStatement preparedStatement=conn.prepareStatement("SELECT PRIX,STOCK FROM MATERIAUX WHERE NOM=?");
          
           preparedStatement.setString(1,nom);
           
           ResultSet rs=preparedStatement.executeQuery();
           
           if(rs.next()){
        	   materiaux=new Materiaux(); 
        	   materiaux.setNom(nom);
        	   materiaux.setPrix(rs.getFloat("PRIX"));
        	   materiaux.setStock(rs.getInt("STOCK"));       	   
           } 

            System.out.println("materiaux lu");
        } catch (SQLException e) {
            try {
                if (conn!=null) conn.rollback();    
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return materiaux;
    }
        
        
        
    public void update(Materiaux materiaux){
        Connection conn = null;
        
        try {
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);
            
           DataSource dataSource=DataSourceProvider.getSingleDataSourceInstance();
           
           conn=dataSource.getConnection();
           
           PreparedStatement preparedStatement=conn.prepareStatement("UPDATE MATERIAUX SET PRIX=?,STOCK=? WHERE NOM=?");
          
           preparedStatement.setString(3, materiaux.getNom());
           preparedStatement.setFloat(1, materiaux.getPrix());
           preparedStatement.setInt(2, materiaux.getStock());
            
           
           preparedStatement.executeUpdate();

            System.out.println("materiaux modifié");
        } catch (SQLException e) {
           /* try {
                if (conn!=null) conn.rollback();    
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) */{
                e.printStackTrace();
            }
          
        }
    }
    
    public List<Materiaux> list(){
        Connection conn = null;
        List<Materiaux> materiaux=new ArrayList<>();
        try {
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);
            
           DataSource dataSource=DataSourceProvider.getSingleDataSourceInstance();
           
           conn=dataSource.getConnection();
           
           PreparedStatement preparedStatement=conn.prepareStatement("SELECT NOM,PRIX,STOCK FROM MATERIAUX");
           
           ResultSet rs=preparedStatement.executeQuery();
           
           while(rs.next()){
               Materiaux materiau = new Materiaux();
               materiau.setPrix(rs.getFloat("PRIX"));
               materiau.setNom(rs.getString("NOM"));
               materiau.setStock(rs.getInt("STOCK"));
               materiaux.add(materiau);
           }
           

            System.out.println("Materiaux lus");
        } catch (SQLException e) {
            try {
                if (conn!=null) conn.rollback();    
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return materiaux;
    }
}
