/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import university.Entities.Users;
import university.EntitiesCrud.UserCrud;
import university.EntitiesJpaControllers.UsersJpaController;

/**
 *
 * @author root
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            boolean emf = Persistence.createEntityManagerFactory("JavaFXApplication6PU").createEntityManager().createNamedQuery("Users.findAll", Users.class).getResultList().isEmpty();
            System.out.println(emf);
            Parent root = FXMLLoader.load(getClass().getResource("/university/FXML/login.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
           
        }catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error in connection!");
            alert.setTitle("Error!");
            alert.showAndWait();
            try {
                stop();
            } catch (Exception ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    

    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }
}
