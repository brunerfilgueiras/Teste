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
@Table(name = "itens_entrada")
@NamedQueries({
    @NamedQuery(name = "ItensEntrada.findAll", query = "SELECT i FROM ItensEntrada i")})
public class ItensEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "valor")
    private float valor;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_entrada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Entrada idEntrada;
    static ItensEntrada instancia = null;      
     
     public static ItensEntrada getInstacia(){
       if(  instancia == null){
         return instancia = new ItensEntrada();
         } else{ 
         return instancia;
       }
     }

    public ItensEntrada() {
    }

    public ItensEntrada(Long id) {
        this.id = id;
    }

    public ItensEntrada(Long id, float valor, int quantidade) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Entrada getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Entrada idEntrada) {
        this.idEntrada = idEntrada;
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
        if (!(object instanceof ItensEntrada)) {
            return false;
        }
        ItensEntrada other = (ItensEntrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ItensEntrada[ id=" + id + " ]";
    }
    
}
