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
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findById", query = "SELECT n FROM Nivel n WHERE n.id = :id"),
    @NamedQuery(name = "Nivel.findByNome", query = "SELECT n FROM Nivel n WHERE n.nome = :nome"),
    @NamedQuery(name = "Nivel.findByConfiguracao", query = "SELECT n FROM Nivel n WHERE n.configuracao = :configuracao"),
    @NamedQuery(name = "Nivel.findByUsuario", query = "SELECT n FROM Nivel n WHERE n.usuario = :usuario"),
    @NamedQuery(name = "Nivel.findByNivel", query = "SELECT n FROM Nivel n WHERE n.nivel = :nivel"),
    @NamedQuery(name = "Nivel.findByProduto", query = "SELECT n FROM Nivel n WHERE n.produto = :produto"),
    @NamedQuery(name = "Nivel.findByRelatorio", query = "SELECT n FROM Nivel n WHERE n.relatorio = :relatorio"),
    @NamedQuery(name = "Nivel.findByFormaPgm", query = "SELECT n FROM Nivel n WHERE n.formaPgm = :formaPgm"),
    @NamedQuery(name = "Nivel.findByLigacaoRecebida", query = "SELECT n FROM Nivel n WHERE n.ligacaoRecebida = :ligacaoRecebida"),
    @NamedQuery(name = "Nivel.findByPedido", query = "SELECT n FROM Nivel n WHERE n.pedido = :pedido"),
    @NamedQuery(name = "Nivel.findByCliente", query = "SELECT n FROM Nivel n WHERE n.cliente = :cliente")})
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CONFIGURACAO")
    private Boolean configuracao;
    @Column(name = "USUARIO")
    private Boolean usuario;
    @Column(name = "NIVEL")
    private Boolean nivel;
    @Column(name = "PRODUTO")
    private Boolean produto;
    @Column(name = "RELATORIO")
    private Boolean relatorio;
    @Column(name = "FORMA_PGM")
    private Boolean formaPgm;
    @Column(name = "LIGACAO_RECEBIDA")
    private Boolean ligacaoRecebida;
    @Column(name = "PEDIDO")
    private Boolean pedido;
    @Column(name = "CLIENTE")
    private Boolean cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelId")
    private Collection<Usuario> usuarioCollection;

    public Nivel() {
    }

    public Nivel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Boolean configuracao) {
        this.configuracao = configuracao;
    }

    public Boolean getUsuario() {
        return usuario;
    }

    public void setUsuario(Boolean usuario) {
        this.usuario = usuario;
    }

    public Boolean getNivel() {
        return nivel;
    }

    public void setNivel(Boolean nivel) {
        this.nivel = nivel;
    }

    public Boolean getProduto() {
        return produto;
    }

    public void setProduto(Boolean produto) {
        this.produto = produto;
    }

    public Boolean getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Boolean relatorio) {
        this.relatorio = relatorio;
    }

    public Boolean getFormaPgm() {
        return formaPgm;
    }

    public void setFormaPgm(Boolean formaPgm) {
        this.formaPgm = formaPgm;
    }

    public Boolean getLigacaoRecebida() {
        return ligacaoRecebida;
    }

    public void setLigacaoRecebida(Boolean ligacaoRecebida) {
        this.ligacaoRecebida = ligacaoRecebida;
    }

    public Boolean getPedido() {
        return pedido;
    }

    public void setPedido(Boolean pedido) {
        this.pedido = pedido;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
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
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Nivel[ id=" + id + " ]";
    }
    
}
