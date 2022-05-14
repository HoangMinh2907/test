/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import pe.plant.PlantDAO;

/**
 *
 * @author PHT
 */
public class DBUtils {
    public static final String URL = "jdbc:sqlserver://localhost;databaseName=PlantShop;user=sa;password=1";
    
    public static void loadDriver() {
        try {
            //Loading a driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
