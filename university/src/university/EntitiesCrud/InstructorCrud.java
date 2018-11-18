/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.EntitiesCrud;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import university.Entities.Instructor;
import university.EntitiesJpaControllers.InstructorJpaController;

/**
 *
 * @author root
 */
public class InstructorCrud {
    
    private final InstructorJpaController ijc;
    private final EntityManagerFactory emf;

    public InstructorCrud() {
        emf = Persistence.createEntityManagerFactory("JavaFXApplication6PU");
        ijc = new InstructorJpaController(emf);
    }
    
    public void createInstructor(Instructor instructor){
        ijc.create(instructor);
    }
    
    public void editInstructor(Instructor instructor) throws Exception{
        ijc.edit(instructor);
    }
    
    public void deleteInstructor(Instructor instructor) throws Exception{
        ijc.destroy(instructor.getId());
    }
    
    public List<Instructor> getAllInstructors(){
        return ijc.findInstructorEntities();
    }
    
    public Instructor getInstructorById(int id){
         Query q = emf.createEntityManager().
                createNamedQuery("Instructor.findById", Instructor.class).setParameter("id", id);
                   Instructor instructor = (Instructor) q.getSingleResult();
                   return instructor;
    }
    
}
