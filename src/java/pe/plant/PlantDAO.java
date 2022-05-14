/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.plant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author PHT
 */
public class PlantDAO {

    public PlantDAO() {
        DBUtils.loadDriver();
    }

    //select plants by name
    public List<Plant> getPlants(String name) {
        List<Plant> list = null;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(DBUtils.URL);
            //Executing the stm
            //Creating and executing sql statements            
            String sql = "select p.*, c.name categoryName from plant p join category c on p.categoryId = c.id where p.name like ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            ResultSet rs = stm.executeQuery();            
            //Loading plant into the list      
            list = new ArrayList<>();
            while (rs.next()) {
                //Loading category corresponding to the plant
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                //Loading the plant
                Plant plant = new Plant();
                plant.setId(rs.getInt("id"));
                plant.setName(rs.getString("name"));
                plant.setPrice(rs.getInt("price"));
                plant.setImgPath(rs.getString("imgPath"));
                plant.setDescription(rs.getString("description"));
                plant.setStatus(rs.getInt("status"));                                
                plant.setCategory(category);
                
                list.add(plant);
            }
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return list;
    }
    
    public int updateStatus(int id, int status) {
        int count = 0;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(DBUtils.URL);
            //Creating and executing sql statements            
            String sql = "update plant set status=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setInt(2, id);
            count = stm.executeUpdate();
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
        return count;
    }

    //select a plant by id
    public Plant selectById(int id) {
        Plant plant = null;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(DBUtils.URL);
            //Executing the stm
            //Creating and executing sql statements            
            String sql = "select p.*, c.name categoryName from plant p join category c on p.categoryId = c.id where p.id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            //Loading plant into the list      
            while (rs.next()) {
                //Loading category corresponding to the plant
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                //Loading the plant
                plant = new Plant();
                plant.setId(rs.getInt("id"));
                plant.setName(rs.getString("name"));
                plant.setPrice(rs.getInt("price"));
                plant.setImgPath(rs.getString("imgPath"));
                plant.setDescription(rs.getString("description"));
                plant.setStatus(rs.getInt("status"));                                
                plant.setCategory(category);
            }
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return plant;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Additional methods 
    ////////////////////////////////////////////////////////////////////////////
    public List<Plant> selectAll() {
        List<Plant> list = null;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(DBUtils.URL);
            //Executing the stm
            //Creating and executing sql statements            
            String sql = "select p.*, c.name categoryName from plant p join category c on p.categoryId = c.id";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //Loading plant into the list      
            list = new ArrayList<>();
            while (rs.next()) {
                //Loading category corresponding to the plant
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                //Loading the plant
                Plant plant = new Plant();
                plant.setId(rs.getInt("id"));
                plant.setName(rs.getString("name"));
                plant.setPrice(rs.getInt("price"));
                plant.setImgPath(rs.getString("imgPath"));
                plant.setDescription(rs.getString("description"));
                plant.setStatus(rs.getInt("status"));                                
                plant.setCategory(category);
                
                list.add(plant);
            }
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return list;
    }
    
    public int insert(Plant plant) {
        int count = 0;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(DBUtils.URL);
            //Executing the stm
            //Creating and executing sql statements            
            String sql = "insert into plant values (?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, plant.getId());
            stm.setString(2, plant.getName());
            stm.setInt(3, plant.getPrice());
            stm.setString(4, plant.getImgPath());
            stm.setString(5, plant.getDescription());
            stm.setInt(6, plant.getStatus());
            stm.setInt(7, plant.getCategory().getId());
            count = stm.executeUpdate();
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
        return count;
    }

    public int update(Plant plant) {
        int count = 0;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(DBUtils.URL);
            //Creating and executing sql statements            
            String sql = "update plant set name=?,price=?,imgPath=?,description=?,status=?,categoryId=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, plant.getName());
            stm.setInt(2, plant.getPrice());
            stm.setString(3, plant.getImgPath());
            stm.setString(4, plant.getDescription());
            stm.setInt(5, plant.getStatus());
            stm.setInt(6, plant.getCategory().getId());
            stm.setInt(7, plant.getId());
            count = stm.executeUpdate();
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
        return count;
    }

    public int delete(int id) {
        int count = 0;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(DBUtils.URL);
            //Creating and executing sql statements            
            String sql = "delete plant where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            count = stm.executeUpdate();
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
        return count;
    }    
}
