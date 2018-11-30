/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoappfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Alexander
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labelStatus;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    @FXML
    public void login(ActionEvent event) throws Exception{
        if (txtUsername.getText().equals("") && txtPassword.getText().equals("")) {
            labelStatus.setText("Login succesfull!");
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("window.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.show();
        } else {
            labelStatus.setText("Login failed...");
        }
    }

    @FXML
    private void handleButtonAction(MouseEvent e) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
