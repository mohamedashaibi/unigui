/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.FXMLControllers;

import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import university.Entities.Instructor;
import university.EntitiesCrud.InstructorCrud;

public class InstructorinfoController {

    @FXML
    private ListView instructorListView;
    @FXML
    private ImageView instructorImageView;
    @FXML
    public Button newInstructorBtn;   
    @FXML
    public Button editInstructorBtn;
    @FXML
    public Button deleteInstructorBtn;
    @FXML
    private ComboBox instructorDepartmentField; 
    @FXML
    private ComboBox instructorNationalityField;
    @FXML
    private TextArea instructorMedicalStateField;
    @FXML
    private TextField instructorNameField;
    @FXML
    private TextField instructorSocialNumberField;
    @FXML
    private TextField instructorBankNameField;
    @FXML
    private TextField instructorAccountNumberField;
    @FXML
    private TextField instructorDobField;
    @FXML
    private TextField instructorStartDateField;
    @FXML
    private ComboBox instructorDegreeField;
    
    private InstructorCrud ic;
    
    public void initialize() {
        ic = new InstructorCrud();
        instructorListView.getItems().setAll(ic.getAllInstructors());
     
        instructorListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListenerImpl());
     
        instructorListView.getSelectionModel().selectFirst();
        
        instructorImageView.setImage(new Image(getClass().getResourceAsStream("/university/Images/new.png"),
                200.0, 200.0, false, false));
        
        Image newImage = new Image(getClass().getResourceAsStream("/university/Images/new.png"),
                30.0, 30.0, false, false);
        Image editImage = new Image(getClass().getResourceAsStream("/university/Images/edit.png"),
                30.0, 30.0, false, false);
        Image deleteImage = new Image(getClass().getResourceAsStream("/university/Images/delete.png"),
                30.0, 30.0, false, false);
        newInstructorBtn.setGraphic(new ImageView(newImage));
        editInstructorBtn.setGraphic(new ImageView(editImage));
        deleteInstructorBtn.setGraphic(new ImageView(deleteImage));
        
    }    

    private class ChangeListenerImpl implements ChangeListener<Instructor> {

        public ChangeListenerImpl() {
        }

        @Override
        public void changed(ObservableValue<? extends Instructor> ov, Instructor oldValue, Instructor newValue) {
            Instructor instructor = (Instructor) newValue;
            System.out.println(instructor.getDepartmentId());
            if(newValue != null){
                instructorNameField.setText(instructor.getName());
                instructorDobField.setText(instructor.getDob());
                instructorDegreeField.setValue(instructor.getDegree());
                instructorStartDateField.setText(instructor.getStartingDate());
                instructorDepartmentField.setValue(instructor.getDepartmentId());
                instructorMedicalStateField.setText(instructor.getMedicalstate());
                instructorAccountNumberField.setText(instructor.getAccountNumber());
                instructorBankNameField.setText(instructor.getBankName());
                instructorNationalityField.setValue(instructor.getNationality());
                instructorSocialNumberField.setText(String.valueOf(instructor.getSocialnumber()));
            }else{
                instructorListView.setDisable(true);
            }
        }
    }
    
}
