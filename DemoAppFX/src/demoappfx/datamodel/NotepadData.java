/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoappfx.datamodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;

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

        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);
                NotepadItem todoItem = new NotepadItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }

    public void storeNotepadItems() throws IOException {

        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<NotepadItem> iter = todoItems.iterator();
            while(iter.hasNext()) {
                NotepadItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }

        } finally {
            if(bw != null) {
                bw.close();
            }
        }

    }}
