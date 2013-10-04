/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
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
        
        EntityManager entityManager = PersistenceUtil.getEntityManager();
       Session session = (Session) entityManager.getDelegate();
        
       List<Montadora> resultado = new ArrayList<Montadora>();
        try{ 
        
            Criteria crit = session.createCriteria(Montadora.class);
            resultado = crit.list();
       
          return resultado; 
        }catch(Exception e){
                   
          resultado = null;
            return  resultado ;
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
    
        
   
