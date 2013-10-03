/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bruner
 */
@Entity
@Table(name = "saida")
@NamedQueries({
    @NamedQuery(name = "Saida.findAll", query = "SELECT s FROM Saida s")})
public class Saida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "observacoes")
    private String observacoes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_ordem_de_servico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrdemDeServico idOrdemDeServico;
    @JoinColumn(name = "id_mecanico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mecanico idMecanico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSaida")
    private Collection<ItensSaida> itensSaidaCollection;
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

    public Saida(Long id) {
        this.id = id;
    }

    public Saida(Long id, Date data) {
        this.id = id;
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdemDeServico getIdOrdemDeServico() {
        return idOrdemDeServico;
    }

    public void setIdOrdemDeServico(OrdemDeServico idOrdemDeServico) {
        this.idOrdemDeServico = idOrdemDeServico;
    }

    public Mecanico getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Mecanico idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Collection<ItensSaida> getItensSaidaCollection() {
        return itensSaidaCollection;
    }

    public void setItensSaidaCollection(Collection<ItensSaida> itensSaidaCollection) {
        this.itensSaidaCollection = itensSaidaCollection;
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
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Saida[ id=" + id + " ]";
    }
    
}
