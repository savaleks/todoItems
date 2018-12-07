/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 *
 * @author Alexander
 */
public class HomePageController implements Initializable{
    
     @FXML
    private Button showData;

    @FXML
    private TableView<?> table;

    @FXML
    void showDBData(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
