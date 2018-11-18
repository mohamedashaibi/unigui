/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.EntitiesCrud;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import university.Entities.SubDepartment;
import university.EntitiesJpaControllers.SubDepartmentJpaController;


public class SubDepartmentCrud {

    private final SubDepartmentJpaController sdjc;
    private final EntityManagerFactory emf;
    
    public SubDepartmentCrud(){
        emf = Persistence.createEntityManagerFactory("JavaFXApplication6PU");
        sdjc = new SubDepartmentJpaController(emf);
    }
    
    public void createSubDepartment(SubDepartment subDepartment){
        sdjc.create(subDepartment);
    }
    
    public void editSubDepartment(SubDepartment subDepartment) throws Exception{
        sdjc.edit(subDepartment);
    }
    
    public void deleteSubDepartment(SubDepartment subDepartment) throws Exception{
        sdjc.destroy(subDepartment.getId());
    }
    
    public void findSubDepartmentById(Integer id){
        sdjc.findSubDepartment(id);
    }
    
    public List<SubDepartment> getAllSubDepartments(){
        return sdjc.findSubDepartmentEntities();
    }
    
    public int getCount(){
        return sdjc.getSubDepartmentCount();
    }
}
