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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "lista_produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaProdutos.findAll", query = "SELECT l FROM ListaProdutos l"),
    @NamedQuery(name = "ListaProdutos.findById", query = "SELECT l FROM ListaProdutos l WHERE l.id = :id"),
    @NamedQuery(name = "ListaProdutos.findByQuantidade", query = "SELECT l FROM ListaProdutos l WHERE l.quantidade = :quantidade"),
    @NamedQuery(name = "ListaProdutos.findByListaId", query = "SELECT l FROM ListaProdutos l WHERE l.listaId = :listaId")})
public class ListaProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    @Basic(optional = false)
    @Column(name = "lista_id")
    private int listaId;
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pedido pedidoId;
    @JoinColumn(name = "PRODUTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produto produtoId;

    public ListaProdutos() {
    }

    public ListaProdutos(Integer id) {
        this.id = id;
    }

    public ListaProdutos(Integer id, int listaId) {
        this.id = id;
        this.listaId = listaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public int getListaId() {
        return listaId;
    }

    public void setListaId(int listaId) {
        this.listaId = listaId;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
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
        if (!(object instanceof ListaProdutos)) {
            return false;
        }
        ListaProdutos other = (ListaProdutos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ListaProdutos[ id=" + id + " ]";
    }
    
}
