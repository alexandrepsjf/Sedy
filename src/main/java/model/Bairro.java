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
@Table(name = "bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b"),
    @NamedQuery(name = "Bairro.findById", query = "SELECT b FROM Bairro b WHERE b.id = :id"),
    @NamedQuery(name = "Bairro.findByBairro", query = "SELECT b FROM Bairro b WHERE b.bairro = :bairro"),
    @NamedQuery(name = "Bairro.findByTaxa", query = "SELECT b FROM Bairro b WHERE b.taxa = :taxa")})
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BAIRRO")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "TAXA")
    private float taxa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bairroId")
    private Collection<Cliente> clienteCollection;

    public Bairro() {
    }

    public Bairro(Integer id) {
        this.id = id;
    }

    public Bairro(Integer id, String bairro, float taxa) {
        this.id = id;
        this.bairro = bairro;
        this.taxa = taxa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
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
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bairro[ id=" + id + " ]";
    }
    
}
