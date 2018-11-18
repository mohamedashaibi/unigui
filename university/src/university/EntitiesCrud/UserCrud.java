/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.EntitiesCrud;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import university.Entities.Users;
import university.EntitiesJpaControllers.UsersJpaController;
import university.EntitiesJpaControllers.exceptions.NonexistentEntityException;


public class UserCrud {
    
    private final EntityManagerFactory emf;
    private final UsersJpaController ujc;
    
    public UserCrud(){
        emf = Persistence.createEntityManagerFactory("JavaFXApplication6PU");
        ujc = new UsersJpaController(emf);
    }
    
    public void createUser(Users user){
        ujc.create(user);
    }
    
    public void editUser(Users user){
        try {
            ujc.edit(user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deleteUser(Users user){
        try {
            ujc.destroy(user.getId());
        } catch (NonexistentEntityException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Users> getAllUsers(){
        return ujc.findUsersEntities();
    }
    
    public Users findUserByUsername(String username) throws NoResultException {
               Query q = emf.createEntityManager().
                createNamedQuery("Users.findByUsername", Users.class).setParameter("username", username);
                   Users user = (Users) q.getSingleResult();
                   return user;
    }
}
