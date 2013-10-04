/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Montadora;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.PersistenceUtil;

/**
 *
 * @author secinfor-04
 */
public class MontadoraDAO {
    
    static MontadoraDAO instancia = null;      
     
     public static MontadoraDAO getInstacia(){
       if(  instancia == null){
         return instancia = new MontadoraDAO();
         } else{ 
         return instancia;
       }
     }
    
    
    
    
    public boolean persistir (Montadora montadora){
   
        
        EntityManager em = PersistenceUtil.getEntityManager();
    try{
        em.getTransaction().begin();
           
        em.merge(montadora);
        
        em.getTransaction().commit();
        
        return true;
        
      }catch(Exception e){
       
        
        return false;
        }
        
    }
   
    
    
    public List listaTodas(){
        List montadoras = null;
        EntityManager em = PersistenceUtil.getEntityManager();
        
        try{ 
           
           Session session = (Session) PersistenceUtil.getEntityManager();
           Criteria criteria = session.createCriteria(Montadora.class) ;
         
           return montadoras = criteria.list();
                               
          
           
        }catch(Exception e){
                   
           
            return  montadoras == null;
        }
      }   
        
       public boolean deletar(Montadora montadora){
         EntityManager em = PersistenceUtil.getEntityManager();
         try{
             em.getTransaction().begin();
             em.remove(montadora);
             em.getTransaction().commit();
             return true;
         }catch(Exception e){
             em.getTransaction().rollback();
             return false;
         }
        
                    
    }
    
    
    
    
    
    
    
    
}  
    
        
   
