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
import javax.persistence.ManyToOne;
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
@Table(name = "telefone_has_ligacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneHasLigacoes.findAll", query = "SELECT t FROM TelefoneHasLigacoes t"),
    @NamedQuery(name = "TelefoneHasLigacoes.findById", query = "SELECT t FROM TelefoneHasLigacoes t WHERE t.id = :id"),
    @NamedQuery(name = "TelefoneHasLigacoes.findByLigacoesId", query = "SELECT t FROM TelefoneHasLigacoes t WHERE t.ligacoesId = :ligacoesId")})
public class TelefoneHasLigacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LIGACOES_ID")
    private int ligacoesId;
    @JoinColumn(name = "TELEFONE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Telefone telefoneId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "telefoneHasLigacoes")
    private Ligacoes ligacoes;

    public TelefoneHasLigacoes() {
    }

    public TelefoneHasLigacoes(Integer id) {
        this.id = id;
    }

    public TelefoneHasLigacoes(Integer id, int ligacoesId) {
        this.id = id;
        this.ligacoesId = ligacoesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLigacoesId() {
        return ligacoesId;
    }

    public void setLigacoesId(int ligacoesId) {
        this.ligacoesId = ligacoesId;
    }

    public Telefone getTelefoneId() {
        return telefoneId;
    }

    public void setTelefoneId(Telefone telefoneId) {
        this.telefoneId = telefoneId;
    }

    public Ligacoes getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(Ligacoes ligacoes) {
        this.ligacoes = ligacoes;
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
        if (!(object instanceof TelefoneHasLigacoes)) {
            return false;
        }
        TelefoneHasLigacoes other = (TelefoneHasLigacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TelefoneHasLigacoes[ id=" + id + " ]";
    }
    
}
