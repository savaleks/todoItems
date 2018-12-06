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
    
    public Connection getConnection() throws SQLException{ 
        Connection con = null;
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String str = "jdbc:mysql://" + Configs.dbhost + ":" + Configs.dbport + "/" + Configs.dbname;
         con = DriverManager.getConnection(str, Configs.dbuser, Configs.dbpass);
         con.close();
      } catch (ClassNotFoundException | SQLException ex) {
      }
        return con;
    }
}
