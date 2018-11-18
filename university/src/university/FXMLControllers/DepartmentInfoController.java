/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.FXMLControllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import university.Entities.Department;
import university.Entities.SubDepartment;
import university.EntitiesCrud.DepartmentCrud;
import university.EntitiesCrud.SubDepartmentCrud;

/**
 * FXML Controller class
 *
 * @author root
 */
public class DepartmentInfoController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button newDepartmentBtn;
    @FXML
    private Button editDepartmentBtn;
    @FXML
    private Button deleteDepartmentBtn;
    @FXML
    private ListView departmentListView;
    @FXML
    private ListView subdepartmentListView;
    @FXML
    private TextField departmentNameField;
    @FXML
    private TextField departmentStartDateField;
    @FXML
    private TextField subDepartmentNameField;
    @FXML
    private TextField subDepartmentStartDateField;
    @FXML
    private ComboBox departmentDeanField;
    @FXML
    private Button departmentSaveBtn;
    @FXML
    private Button subDepartmentSaveBtn;
    @FXML
    private Button addSubBtn;
    @FXML
    private Button editSubBtn;
    @FXML
    private Button deleteSubBtn;
    
    private DepartmentCrud dc;
    
    private SubDepartmentCrud sdjc;
    
    private int newDepCount, editDepCount;
    
    private int newSubCount, editSubCount;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        sdjc = new SubDepartmentCrud();
        
        dc = new DepartmentCrud();
    
        newDepCount = editDepCount = 0;
        
        newSubCount = editSubCount = 0;
        
        departmentListView.setDisable(false);
        
        departmentListView.getItems().setAll(dc.getAllDepartments());
        
        departmentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Department>(){
            @Override
            public void changed(ObservableValue<? extends Department> observable, Department oldValue, Department newValue) {
                Department department = (Department) newValue;
                if(department != null){
                    departmentNameField.setText(department.getName());
                    departmentStartDateField.setText(department.getStartDate().toString());
                    departmentDeanField.setValue(department.getInstructorId() == null?"":department.getInstructorId().getName());
                    subdepartmentListView.getItems().setAll(department.getSubDepartmentList()!=null?department.getSubDepartmentList():null);
                }
            }   
        });
        
        departmentListView.getSelectionModel().selectFirst();
        
        subdepartmentListView.getSelectionModel().selectFirst();
        
        subDepartmentSaveBtn.setVisible(false);
        
        subdepartmentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SubDepartment>() {
            @Override
            public void changed(ObservableValue<? extends SubDepartment> observable, SubDepartment oldValue, SubDepartment newValue) {
                SubDepartment subDepartment = (SubDepartment) newValue;
                if(subDepartment != null){
                    subDepartmentNameField.setText(subDepartment.getName());
                    subDepartmentStartDateField.setText(subDepartment.getStartDate());
                }
            }
        });
        
        Image newImage = new Image(getClass().getResourceAsStream("/university/Images/new.png"),
                30.0, 30.0, false, false);
        Image editImage = new Image(getClass().getResourceAsStream("/university/Images/edit.png"),
                30.0, 30.0, false, false);
        Image deleteImage = new Image(getClass().getResourceAsStream("/university/Images/delete.png"),
                30.0, 30.0, false, false);
        newDepartmentBtn.setGraphic(new ImageView(newImage));
        editDepartmentBtn.setGraphic(new ImageView(editImage));
        deleteDepartmentBtn.setGraphic(new ImageView(deleteImage));
        departmentSaveBtn.setVisible(false);
        subDepartmentSaveBtn.setVisible(false);
        
    }    

    @FXML
    private void saveBtnPressed(ActionEvent event) {
     
    }
    
    @FXML
    private void subSaveBtnPressed(ActionEvent event) {
        if(newSubCount == 1){
          if(!"".equals(subDepartmentNameField.getText())){
              SubDepartment subDepartment = new SubDepartment(sdjc.getCount()+1,
                      subDepartmentNameField.getText(), subDepartmentStartDateField.getText());
              subDepartment.setDepartmentId((Department) departmentListView.getSelectionModel().getSelectedItem());
              sdjc.createSubDepartment(subDepartment);
              newSubCount=0;
              initialize();
          }else{
              System.out.println("Cannot do this cos empty name field!");
          }  
          newSubCount=0;
        }else if(editSubCount == 1){
          if(!"".equals(subDepartmentNameField.getText())){
              SubDepartment subDepartment = (SubDepartment) 
                      subdepartmentListView.getSelectionModel().getSelectedItem();
              subDepartment.setName(subDepartmentNameField.getText());
              try {
                  sdjc.editSubDepartment(subDepartment);
              } catch (Exception ex) {
              
              }
              editSubCount=0;
          }  else{
              
          }
             editSubCount=0;
        }
        
    }
    
    @FXML
    private void addSubDepartment(){
        subDepartmentSaveBtn.setVisible(true);
        newSubCount = 1;
        subDepartmentNameField.setText("");
        subDepartmentStartDateField.setEditable(false);
        subDepartmentStartDateField.setText(LocalDate.now().toString());
        addSubBtn.setVisible(false);
        editSubBtn.setVisible(false);
        deleteSubBtn.setVisible(false);
    }
    
    @FXML
    private void editSubDepartment(){
        editSubCount = 1;
        editSubBtn.setVisible(false);
        subDepartmentSaveBtn.setVisible(true);
    }
    
    @FXML
    private void deleteSubDepartment(){
        
    }
    
}
