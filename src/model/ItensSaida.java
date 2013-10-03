/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Bruner
 */
@Entity
@Table(name = "itens_saida")
@NamedQueries({
    @NamedQuery(name = "ItensSaida.findAll", query = "SELECT i FROM ItensSaida i")})
public class ItensSaida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_saida", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Saida idSaida;
    static ItensSaida instancia = null;      
     
     public static ItensSaida getInstacia(){
       if(  instancia == null){
         return instancia = new ItensSaida();
         } else{ 
         return instancia;
       }
     }

    public ItensSaida() {
    }

    public ItensSaida(Long id) {
        this.id = id;
    }

    public ItensSaida(Long id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Saida getIdSaida() {
        return idSaida;
    }

    public void setIdSaida(Saida idSaida) {
        this.idSaida = idSaida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensSaida)) {
            return false;
        }
        ItensSaida other = (ItensSaida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ItensSaida[ id=" + id + " ]";
    }
    
}
