/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoappfx;

import demoappfx.datamodel.NotepadData;
import demoappfx.datamodel.NotepadItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Alexander
 */
public class WindowController {
    
   private List<NotepadItem> todoItems;

    @FXML
    private ListView<NotepadItem> notepadView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    public void initialize() {
        NotepadItem item1 = new NotepadItem("Mail birthday card", "Buy a 30th birthday card for John",
                LocalDate.of(2016, Month.APRIL, 25));
        NotepadItem item2 = new NotepadItem("Doctor's Appointment", "See Dr. Smith at 123 Main Street.  Bring paperwork",
                LocalDate.of(2016, Month.MAY, 23));
        NotepadItem item3 = new NotepadItem("Finish design proposal for client", "I promised Mike I'd email website mockups by Friday 22nd April",
                LocalDate.of(2016, Month.APRIL, 22));
        NotepadItem item4 = new NotepadItem("Pickup Doug at the train station", "Doug's arriving on March 23 on the 5:00 train",
                LocalDate.of(2016, Month.MARCH, 23));
        NotepadItem item5 = new NotepadItem("Pick up dry cleaning", "The clothes should be ready by Wednesday",
                LocalDate.of(2016, Month.APRIL,20));

        todoItems = new ArrayList<NotepadItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);
        
        NotepadData.getInstance().setTodoItems(todoItems);

        notepadView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<NotepadItem>() {
            @Override
            public void changed(ObservableValue<? extends NotepadItem> observable, NotepadItem oldValue, NotepadItem newValue) {
                if(newValue != null) {
                    NotepadItem item = notepadView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                }
            }
        });

        notepadView.getItems().setAll(todoItems);
        notepadView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        notepadView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        NotepadItem item = notepadView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }
}

