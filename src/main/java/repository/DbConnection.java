/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class DbConnection {

    private static Connection connection;
    public static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    
    static {
         
        URL = "jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL";
//        URL = "jdbc:mysql://localhost:3306/" + repository.Dao.DB
//                + "?useUnicode=true"
//                + "&useJDBCCompliantTimezoneShift=true"
//                + "&serverTimezone=UTC"
//                + "&autoReconnect=true";
        USER = "root";
        PASSWORD = "juliacaio810";
    }

    
    private DbConnection() {
    }
  

    public static Connection getConnection() {

        
        if (connection == null) {
            
            try {
                System.out.println(">> New database connection");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return connection;
    }
}


