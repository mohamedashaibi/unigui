/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.FXMLControllers;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import university.Entities.Users;
import university.EntitiesCrud.UserCrud;

public class LoginController {

    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public VBox vBox;
    
    private UserCrud userCrud;
    
    private FXMLLoader fxmlLoader;
    
    public void initialize() {
      
            userCrud = new UserCrud();
       
    }    
    
    public void loginBtnPressed(){
        String username = usernameField.getText();
        String password = passwordField.getText();
            if(!username.equals("") && !password.equals("")){
                try{
                Users user = userCrud.findUserByUsername(username);
                    if(password.equals(user.getPassword())){
                        System.out.println("LOGGED IN SUCCESSFULLY!");
                        ControlPanelController.userPriv = user.getPrivilege();
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("/university/FXML/controlpanel.fxml"));
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.setTitle("Control panel");
                            stage.show();
                            vBox.getScene().getWindow().hide();
                        } catch (IOException | NullPointerException ex) {
                            makeDialog("Couldn't open control panel, an error occured \n" + ex.getMessage());
                        }
                    }else{
                        makeDialog("Password isn't correct!");
                    }    
                }catch(NoResultException ex){
                    makeDialog("User not found!");
                }
            }else{
                makeDialog("Please enter BOTH Username AND Password!");
            }
        }
    
    public void makeDialog(String errorMessage){
        Dialog<ButtonType> dialog =  new Dialog<>();
        dialog.initOwner(vBox.getScene().getWindow());
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
