/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import alertmessage.Message;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import loginapptodoitem.DBConnection.ConnectionClass;

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
    
    PreparedStatement pst;
    Connection con;
    ConnectionClass conClass = new ConnectionClass();
    Message msg = new Message();
    
    @FXML
    void createlogin(ActionEvent event) throws SQLException, IOException {
       
        con = conClass.getConnection();
        String str = "SELECT * FROM student WHERE fullName=? and password=?";
        pst = con.prepareStatement(str);
        pst.setString(1, username.getText());
        pst.setString(2, password.getText());
        
        ResultSet rs = pst.executeQuery();
        int count = 0;
        
        while(rs.next()){
            count = count+1;
        }
        
        if (count == 1) {
            //msg.setMessage("Login successful!");
            
            login.getScene().getWindow().hide();
            Stage home = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/loginapptodoitem/FXML_Files/TodoWindow.fxml"));
            home.setScene(new Scene(root));
            home.show();
            
        } else {
            msg.setMessage("Login failed..");
        }
    }

    @FXML
    void createregister(ActionEvent event) throws IOException {

        register.getScene().getWindow().hide();
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/loginapptodoitem/FXML_Files/SignUp.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
    }
}
