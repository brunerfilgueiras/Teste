/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MontadoraDAO;
import model.Montadora;

/**
 *
 * @author secinfor-04
 */
public class MontadoraController {
    
    static MontadoraController instancia = null;      
     
     public static MontadoraController getInstacia(){
       if(  instancia == null){
         return instancia = new MontadoraController();
         } else{ 
         return instancia;
       }
     }
    
    
    
   public boolean persistir(Montadora montadora){
       
      MontadoraDAO montadoraDAO = MontadoraDAO.getInstacia();
    
      return montadoraDAO.persistir(montadora);
      
         
   }
   public boolean deletar(Montadora montadora){
       
      MontadoraDAO montadoraDAO = MontadoraDAO.getInstacia();
    
      return montadoraDAO.deletar(montadora);
      
         
   } 
  
  
   
   
   
   
   
   
   
}
