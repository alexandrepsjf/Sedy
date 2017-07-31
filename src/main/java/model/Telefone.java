/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t"),
    @NamedQuery(name = "Telefone.findById", query = "SELECT t FROM Telefone t WHERE t.id = :id"),
    @NamedQuery(name = "Telefone.findByClienteId", query = "SELECT t FROM Telefone t WHERE t.clienteId = :clienteId"),
    @NamedQuery(name = "Telefone.findByTelefone", query = "SELECT t FROM Telefone t WHERE t.telefone = :telefone")})
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CLIENTE_ID")
    private int clienteId;
    @Basic(optional = false)
    @Column(name = "TELEFONE")
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENTE_ID", insertable = false, updatable = false)
    private Cliente cliente;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefoneId")
//    private Collection<TelefoneHasLigacoes> telefoneHasLigacoesCollection;

    public Telefone() {
    }

    public Telefone(Integer id) {
        this.id = id;
    }
    
   
    public Telefone(Integer id,  String telefone) {
        this.id = id;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
//
//    @XmlTransient
//    public Collection<TelefoneHasLigacoes> getTelefoneHasLigacoesCollection() {
//        return telefoneHasLigacoesCollection;
//    }
//
//    public void setTelefoneHasLigacoesCollection(Collection<TelefoneHasLigacoes> telefoneHasLigacoesCollection) {
//        this.telefoneHasLigacoesCollection = telefoneHasLigacoesCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Telefone[ id=" + id + " ]";
    }
    
}
