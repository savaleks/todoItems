/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoappfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Alexander
 */
public class MainDemoAppFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Button bt = new Button("handleButtonAction");
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //stage.setTitle("Notepad");
        stage.initStyle(StageStyle.UNDECORATED);
               
        Scene scene = new Scene(root);
       
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
//    public void pressButton(MouseEvent event) throws Exception {               
//        try{
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("window.fxml"));
//            Parent root1 = (Parent) fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.initStyle(StageStyle.UNDECORATED);
//            stage.setScene(new Scene(root1));  
//            stage.show();
//        } catch(Exception e) {
//           e.printStackTrace();
//          }
//}
    
}
