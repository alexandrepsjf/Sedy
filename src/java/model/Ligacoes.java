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
@Table(name = "ligacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ligacoes.findAll", query = "SELECT l FROM Ligacoes l"),
    @NamedQuery(name = "Ligacoes.findById", query = "SELECT l FROM Ligacoes l WHERE l.id = :id"),
    @NamedQuery(name = "Ligacoes.findByLigacao", query = "SELECT l FROM Ligacoes l WHERE l.ligacao = :ligacao")})
public class Ligacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LIGACAO")
    private String ligacao;
    @JoinColumn(name = "ID", referencedColumnName = "LIGACOES_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TelefoneHasLigacoes telefoneHasLigacoes;

    public Ligacoes() {
    }

    public Ligacoes(Integer id) {
        this.id = id;
    }

    public Ligacoes(Integer id, String ligacao) {
        this.id = id;
        this.ligacao = ligacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLigacao() {
        return ligacao;
    }

    public void setLigacao(String ligacao) {
        this.ligacao = ligacao;
    }

    public TelefoneHasLigacoes getTelefoneHasLigacoes() {
        return telefoneHasLigacoes;
    }

    public void setTelefoneHasLigacoes(TelefoneHasLigacoes telefoneHasLigacoes) {
        this.telefoneHasLigacoes = telefoneHasLigacoes;
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
        if (!(object instanceof Ligacoes)) {
            return false;
        }
        Ligacoes other = (Ligacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ligacoes[ id=" + id + " ]";
    }
    
}
