/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "forma_pgm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "forma_pgm.findAll", query = "SELECT f FROM FormaPgm f"),
    @NamedQuery(name = "forma_pgm.findById", query = "SELECT f FROM FormaPgm f WHERE f.id = :id"),
    @NamedQuery(name = "forma_pgm.findByForma", query = "SELECT f FROM FormaPgm f WHERE f.forma = :forma")})
public class FormaPgm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FORMA")
    private String forma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPgmId")
    private Collection<Pedido> pedidoCollection;

    public FormaPgm() {
    }

    public FormaPgm(Integer id) {
        this.id = id;
    }

    public FormaPgm(Integer id, String forma) {
        this.id = id;
        this.forma = forma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
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
        if (!(object instanceof FormaPgm)) {
            return false;
        }
        FormaPgm other = (FormaPgm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FormaPgm[ id=" + id + " ]";
    }
    
}
