/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertmessage;

import javafx.scene.control.Alert;

/**
 *
 * @author Alexander
 */
public class Message {
    
    public void setMessage(String str){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Alert message!");
        alert.setContentText(str);
        alert.show();
    }
    
}
