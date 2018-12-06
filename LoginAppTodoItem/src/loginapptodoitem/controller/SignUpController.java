/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        fullname.setStyle("-fx-text-inner-color: #0080FF");
        email.setStyle("-fx-text-inner-color: #0080FF");
        password.setStyle("-fx-text-inner-color: #0080FF");
    }
    
}
