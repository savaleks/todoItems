/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoappfx.datamodel;

import java.time.LocalDate;

/**
 *
 * @author Alexander
 */
public class NotepadItem {
    private String shortDescription;
    private String details;
    private LocalDate date;

    public NotepadItem(String shortDescription, String details, LocalDate date) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.date = date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return shortDescription;
    }
    
    
}
