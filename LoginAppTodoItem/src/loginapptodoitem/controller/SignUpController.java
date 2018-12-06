/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import loginapptodoitem.DBConnection.ConnectionClass;

/**
 *
 * @author Alexander
 */
public class SignUpController implements Initializable{

      @FXML
    private TextField fullname;

    @FXML
    private PasswordField email;

    @FXML
    private TextField password;

    @FXML
    private CheckBox check;

    @FXML
    private Button signup;

    @FXML
    private Button login;
    
    ConnectionClass conToDB = new ConnectionClass();
    Connection con;
    
    private PreparedStatement ps;
    
    @FXML
    public void logIN(ActionEvent event) throws IOException {

        login.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/loginapptodoitem/FXML_Files/Login.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.show();
    }

    @FXML
    public void signUP(ActionEvent event) throws SQLException {

        con = conToDB.getConnection();
        String insert = "INSERT INTO student(fullName, password, email) VALUES(?,?,?)";               
        ps = con.prepareStatement(insert);
        
        ps.setString(1, fullname.getText());
        ps.setString(2, password.getText());
        ps.setString(3, email.getText());
        
        ps.executeUpdate();
        System.out.println("Data inserted");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        fullname.setStyle("-fx-text-inner-color: #0080FF");
        email.setStyle("-fx-text-inner-color: #0080FF");
        password.setStyle("-fx-text-inner-color: #0080FF");
    }
    
}
