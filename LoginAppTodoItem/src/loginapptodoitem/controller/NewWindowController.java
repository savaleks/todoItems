/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import alertmessage.Message;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import loginaootodoitem.datamodel.NotepadData;
import loginaootodoitem.datamodel.NotepadItem;
import loginapptodoitem.DBConnection.ConnectionClass;

/**
 *
 * @author Alexander
 */
public class NewWindowController {

    @FXML
    private DialogPane insertData;

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    private PreparedStatement ps;
    Message msg = new Message();

    public void processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        NotepadData.getInstance().addTodoItem(new NotepadItem(shortDescription, details, deadlineValue));
    }

    public void insertToDB() throws SQLException {

        // == insert data to database ==
        ConnectionClass conToDB = new ConnectionClass();
        Connection connection;
        connection = conToDB.getConnection();
        String insert = "INSERT INTO todoitem(title, describtion, data) VALUES(?,?,?)";
        ps = connection.prepareStatement(insert);
        LocalDate data = deadlinePicker.getValue();

        ps.setString(1, shortDescriptionField.getText());
        ps.setString(2, detailsArea.getText());
        ps.setDate(3, Date.valueOf(data));

        ps.executeUpdate();
        msg.setMessage("Data inserted!");
        connection.close();
    }
}
