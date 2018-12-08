/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import loginapptodoitem.DBConnection.ConnectionClass;

/**
 *
 * @author Alexander
 */
public class HomePageController implements Initializable{
    
     @FXML
    private Button showData;

    @FXML
    private TableView<Student> table;
    
   @FXML
    private TableColumn<Student, String> fullname;

    @FXML
    private TableColumn<Student, String> password;

    @FXML
    private TableColumn<Student, String> email;
    
    Connection con;
    PreparedStatement pst;
    ConnectionClass conObj = new ConnectionClass();
    
    @FXML
    void showDBData(ActionEvent event) throws SQLException {

        con = conObj.getConnection();
        ObservableList<Student> data = FXCollections.observableArrayList();
        table.setItems(data);
        String str = "SELECT * FROM student";
        pst = con.prepareStatement(str);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {            
            Student student = new Student(rs.getString("fullName"), rs.getString("password"), rs.getString("email"));
            data.add(student);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      
        fullname.setCellValueFactory(new PropertyValueFactory<Student, String>("fullName"));
        password.setCellValueFactory(new PropertyValueFactory<Student, String>("password"));
        email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
    }
}
