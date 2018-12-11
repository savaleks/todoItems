/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginaootodoitem.datamodel;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Alexander
 */
//singleton
public class NotepadData {

    private static NotepadData instance = new NotepadData();
    private static String filename = "NotepadFX.txt";

    private List<NotepadItem> todoItems;
    private DateTimeFormatter formatter;

    public static NotepadData getInstance() {
        return instance;
    }

    private NotepadData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<NotepadItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<NotepadItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void loadTodoItems() throws IOException {

      
    }

    public void storeTodoItems() throws IOException {

        


    }
}
