/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoappfx;

import demoappfx.datamodel.NotepadItem;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

/**
 *
 * @author Alexander
 */
public class WindowController {
    
    private List<NotepadItem> notepadItem;
    
    @FXML
    private ListView<NotepadItem> notepadView;
    @FXML
    private TextArea itemDetails;
    @FXML
    private Label deadlineLabel;
    
    // inicializuojame uzrasus naujame lange;
    public void initialize(){
        NotepadItem item1 = new NotepadItem("Example", "Notepad example", LocalDate.of(2018, Month.OCTOBER, 23));
        
        notepadItem = new ArrayList<NotepadItem>();
        notepadItem.add(item1);
        
        //notepadView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<NotepadItem>){
        
    //}
        
        notepadView.getItems().setAll(notepadItem);
        notepadView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    
    //paspaudus ant uzraso kaireje gaunam to uzraso aprasyma;
    @FXML
    public void handleClickListView(){
        NotepadItem item = notepadView.getSelectionModel().getSelectedItem();
       
        itemDetails.setText(item.getDetails());
        deadlineLabel.setText(item.getDate().toString());
    }
 }
