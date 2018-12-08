/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapptodoitem.controller;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Alexander
 */
public class Student {
    
    private final SimpleStringProperty fullname;
    private final SimpleStringProperty password;
    private final SimpleStringProperty email;
    
    Student(String fname, String pass, String mail){
        this.fullname = new SimpleStringProperty(fname);
        this.password = new SimpleStringProperty(pass);
        this.email = new SimpleStringProperty(mail);
    }

    public String getFullName() {
        return fullname.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getEmail() {
        return email.get();
    }
    
    public void setFullName(String fname){
        fullname.set(fname);
    }
    
    public void setPassword(String pass){
        password.set(pass);
    }
    
    public void setEmail(String mail){
        email.set(mail);
    }
}
