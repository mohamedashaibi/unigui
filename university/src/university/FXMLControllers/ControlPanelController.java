/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.FXMLControllers;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author root
 */
public class ControlPanelController {

    @FXML
    private Button studentBtn;
    @FXML
    private Button instructorBtn;
    @FXML
    private Button sectionBtn;
    @FXML
    private Button departmentBtn;
    @FXML
    private Button subjectBtn;
    @FXML
    private BorderPane borderPane;

    public static short userPriv;
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        System.out.println(userPriv);
        // TODO
    }    

    @FXML
    private void studentBtnPressed(ActionEvent event) {
    }

    @FXML
    private void instructorBtnPressed() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/university/FXML/instructorinfo.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Instructor information");
            stage.show();
            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            makeDialog("An error has occured \n" + ex.getMessage());
        }
    }

    @FXML
    private void sectionBtnPressed(ActionEvent event) {
    }

    @FXML
    private void departmentBtnPressed(ActionEvent event) {
           try {
            Parent root = FXMLLoader.load(getClass().getResource("/university/FXML/departmentinfo.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Department information");
            stage.show();
            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            makeDialog("An error has occured \n" + ex.getMessage());
        }
    }

    @FXML
    private void subjectBtnPressed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/university/FXML/subjectinfo.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Subject information");
            stage.show();
            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
            makeDialog("An error has occured \n");
        }
    }
    
    public void makeDialog(String errorMessage){
        Dialog<ButtonType> dialog =  new Dialog<>();
        dialog.initOwner(borderPane.getScene().getWindow());
        dialog.setTitle("Error!");
        dialog.setContentText(errorMessage);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.setHeight(100);
        dialog.setWidth(200);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && (result.get() == ButtonType.OK || result.get() == ButtonType.CANCEL)){
            dialog.close();
        }
    }
    
}
