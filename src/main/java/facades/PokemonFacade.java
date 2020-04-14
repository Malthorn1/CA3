/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author mikke
 */
public class PokemonFacade {
    
      
    private static EntityManagerFactory emf;
    private static PokemonFacade instance;

    public PokemonFacade() {
    }
    
        public static PokemonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PokemonFacade();
        }
        return instance;
    }

            private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Object getPokemonById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

            
    
    
}
