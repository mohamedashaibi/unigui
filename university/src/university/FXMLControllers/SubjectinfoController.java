/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.FXMLControllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import university.Entities.Subject;
import university.EntitiesCrud.SubjectCrud;

/**
 * FXML Controller class
 *
 * @author root
 */
public class SubjectinfoController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private ListView subjectListView;
    @FXML
    private TextField subjectNameField;
    @FXML
    private TextField subjectCodeField;
    @FXML
    private TextField subjectUnitsField;
    @FXML
    private ComboBox subjectPre1Field;
    @FXML
    private ComboBox subjectPre2Field;
    @FXML
    private ComboBox subjectPre3Field;
    @FXML
    private ComboBox subjectPre4Field;
    @FXML
    private Button subjectSaveBtn;
    @FXML
    private Button newSubjectBtn;
    @FXML
    private Button editSubjectBtn;
    @FXML
    private Button deleteSubjectBtn;
    
    private SubjectCrud sc;
    
    private int newCount, editCount;
    @FXML
    private Button newDepartmentBtn;
    @FXML
    private Button editDepartmentBtn;
    @FXML
    private Button deleteDepartmentBtn;
    @FXML
    private ListView<?> departmentListView;
    @FXML
    private TextField departmentNameField;
    @FXML
    private TextField departmentStartDateField;
    @FXML
    private Button departmentSaveBtn;
    
    public void initialize() {
        sc = new SubjectCrud();
        
        newCount = editCount = 0;

        subjectSaveBtn.setVisible(false);

        subjectListView.getItems().setAll(sc.getAllSubjects());
        
        subjectListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListenerImpl());
        
        subjectListView.getSelectionModel().selectFirst();
        
        Image newImage = new Image(getClass().getResourceAsStream("/university/Images/new.png"),
                30.0, 30.0, false, false);
        Image editImage = new Image(getClass().getResourceAsStream("/university/Images/edit.png"),
                30.0, 30.0, false, false);
        Image deleteImage = new Image(getClass().getResourceAsStream("/university/Images/delete.png"),
                30.0, 30.0, false, false);
        newSubjectBtn.setGraphic(new ImageView(newImage));
        editSubjectBtn.setGraphic(new ImageView(editImage));
        deleteSubjectBtn.setGraphic(new ImageView(deleteImage));
        
    }    

    @FXML
    private void saveBtnPressed(ActionEvent event) {
    }

    private class ChangeListenerImpl implements ChangeListener<Subject> {

        public ChangeListenerImpl() {
        }

        @Override
        public void changed(ObservableValue<? extends Subject> observable, Subject oldValue, Subject newValue) {
            Subject subject = (Subject) newValue;
            if(subject != null){
                subjectNameField.setText(subject.getName());
                subjectCodeField.setText(subject.getCode());
                subjectUnitsField.setText(String.valueOf(subject.getUnits()));
                subjectPre1Field.setValue(subject.getPrerequisite1());
                subjectPre2Field.setValue(subject.getPrerequisite2());
                subjectPre3Field.setValue(subject.getPrerequisite3());
                subjectPre4Field.setValue(subject.getPrerequisite4());
            }
        }
    }
    
}
