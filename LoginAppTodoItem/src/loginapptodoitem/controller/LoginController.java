/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import loginapptodoitem.DBConnection.Connection;

/**
 *
 * @author Alexander
 */
public class LoginController {

    @FXML
    private AnchorPane anPane;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private Button login;
    
    Connection con;
    
    Connection conClass = new Connection();
    

    @FXML
    void createlogin(ActionEvent event) throws SQLException {

        con = conClass.getConnection();
        System.out.println(con);
        System.out.println("Connection successful");
    }

    @FXML
    void createregister(ActionEvent event) {

    }

}
