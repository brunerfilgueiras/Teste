package model;
// Generated 22/09/2013 15:07:10 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Saida generated by hbm2java
 */
public class Saida  implements java.io.Serializable {


     private Long id;
     private Usuario usuario;
     private Mecanico mecanico;
     private OrdemDeServico ordemDeServico;
     private Date data;
     private String observacoes;
     private Set itensSaidas = new HashSet(0);
     static Saida instancia = null;   
   
     
     public static Saida getInstacia(){
       if(  instancia == null){
         return instancia = new Saida();
         } else{ 
         return instancia;
       }
     }
    public Saida() {
    }

	
    public Saida(Usuario usuario, Mecanico mecanico, OrdemDeServico ordemDeServico, Date data) {
        this.usuario = usuario;
        this.mecanico = mecanico;
        this.ordemDeServico = ordemDeServico;
        this.data = data;
    }
    public Saida(Usuario usuario, Mecanico mecanico, OrdemDeServico ordemDeServico, Date data, String observacoes, Set itensSaidas) {
       this.usuario = usuario;
       this.mecanico = mecanico;
       this.ordemDeServico = ordemDeServico;
       this.data = data;
       this.observacoes = observacoes;
       this.itensSaidas = itensSaidas;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Mecanico getMecanico() {
        return this.mecanico;
    }
    
    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }
    public OrdemDeServico getOrdemDeServico() {
        return this.ordemDeServico;
    }
    
    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public String getObservacoes() {
        return this.observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public Set getItensSaidas() {
        return this.itensSaidas;
    }
    
    public void setItensSaidas(Set itensSaidas) {
        this.itensSaidas = itensSaidas;
    }




}


