/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexander
 */
public class ConnectionClass extends Configs{
    
    Connection con;
    
    public Connection getConnection() throws SQLException{ 
        
        try {
     
         Class.forName("com.mysql.cj.jdbc.Driver");
         String str = "jdbc:mysql://localhost/course";
         con = DriverManager.getConnection(str, Configs.dbuser, Configs.dbpass);
         //con.close();
      } catch (ClassNotFoundException | SQLException ex) {
          ex.getStackTrace();
      }
        return con;
    }
}
