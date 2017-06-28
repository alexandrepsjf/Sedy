/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findById", query = "SELECT e FROM Email e WHERE e.id = :id"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email"),
    @NamedQuery(name = "Email.findBySenha", query = "SELECT e FROM Email e WHERE e.senha = :senha"),
    @NamedQuery(name = "Email.findByAutentica", query = "SELECT e FROM Email e WHERE e.autentica = :autentica"),
    @NamedQuery(name = "Email.findByServidorSaida", query = "SELECT e FROM Email e WHERE e.servidorSaida = :servidorSaida"),
    @NamedQuery(name = "Email.findByServidorEntrada", query = "SELECT e FROM Email e WHERE e.servidorEntrada = :servidorEntrada")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "autentica")
    private String autentica;
    @Basic(optional = false)
    @Column(name = "servidorSaida")
    private String servidorSaida;
    @Basic(optional = false)
    @Column(name = "servidorEntrada")
    private String servidorEntrada;

    public Email() {
    }

    public Email(Integer id) {
        this.id = id;
    }

    public Email(Integer id, String email, String senha, String autentica, String servidorSaida, String servidorEntrada) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.autentica = autentica;
        this.servidorSaida = servidorSaida;
        this.servidorEntrada = servidorEntrada;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAutentica() {
        return autentica;
    }

    public void setAutentica(String autentica) {
        this.autentica = autentica;
    }

    public String getServidorSaida() {
        return servidorSaida;
    }

    public void setServidorSaida(String servidorSaida) {
        this.servidorSaida = servidorSaida;
    }

    public String getServidorEntrada() {
        return servidorEntrada;
    }

    public void setServidorEntrada(String servidorEntrada) {
        this.servidorEntrada = servidorEntrada;
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
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Email[ id=" + id + " ]";
    }
    
}
