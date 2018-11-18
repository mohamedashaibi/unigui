/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.EntitiesCrud;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import university.Entities.Department;
import university.EntitiesJpaControllers.DepartmentJpaController;
import university.EntitiesJpaControllers.SubDepartmentJpaController;

/**
 *
 * @author root
 */
public class DepartmentCrud {
    
    private final EntityManagerFactory emf;
    private final DepartmentJpaController djc;
    private final SubDepartmentJpaController sdjc;
    
    public DepartmentCrud(){
        emf = Persistence.createEntityManagerFactory("JavaFXApplication6PU");
        djc = new DepartmentJpaController(emf);
        sdjc = new SubDepartmentJpaController(emf);
    }
    
    public void createDepartment(Department department){
        djc.create(department);
    }
    
    public void editDepartment(Department department) throws Exception{
        djc.edit(department);
    }
    
    public void deleteDepartment(Department department)throws Exception{
        djc.destroy(department.getId());
    }
    
    public List<Department> getAllDepartments(){
        return djc.findDepartmentEntities();
    }
    
    public Department findDepartmentById(int id){
        return djc.findDepartment(id);
    }
}
