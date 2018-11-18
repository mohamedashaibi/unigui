/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.EntitiesCrud;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import university.Entities.Subject;
import university.EntitiesJpaControllers.SubjectJpaController;


public class SubjectCrud {

    private final EntityManagerFactory emf;
    private final SubjectJpaController sjc;
    
    public SubjectCrud(){
        emf = Persistence.createEntityManagerFactory("JavaFXApplication6PU");
        sjc = new SubjectJpaController(emf);
    }
    
    public void createSubject(Subject subject){
        sjc.create(subject);
    }
    
    public void editSubject(Subject subject) throws Exception{
        sjc.edit(subject);
    }
    
    public void deleteSubject(Subject subject) throws Exception{
        sjc.destroy(subject.getId());
    }
    
    public List<Subject> getAllSubjects(){
        return sjc.findSubjectEntities();
    }
    
    public Subject findSubjectById(short id){
        return sjc.findSubject(id);
    }
}
