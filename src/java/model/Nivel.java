/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.NivelDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sujajeb
 */
@Entity
public class Nivel implements Serializable{
private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
    private String nome;
    private int configuracao;
    private int usuario;
    private int nivel;
    private int produto;
    private int relatorio;
    private int formaPagamento;
    private int ligacaoRecebida;
    private int pedido;
    private int cliente;

    public Nivel(int id, String nome, int configuracao, int usuario, int nivel, int produto, int relatorio, int formaPagamento, int ligacaoRecebida, int pedido, int cliente) {
        this.id = id;
        this.nome = nome;
        this.configuracao = configuracao;
        this.usuario = usuario;
        this.nivel = nivel;
        this.produto = produto;
        this.relatorio = relatorio;
        this.formaPagamento = formaPagamento;
        this.ligacaoRecebida = ligacaoRecebida;
        this.pedido = pedido;
        this.cliente = cliente;
    }

    public Nivel() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(int configuracao) {
        this.configuracao = configuracao;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(int relatorio) {
        this.relatorio = relatorio;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getLigacaoRecebida() {
        return ligacaoRecebida;
    }

    public void setLigacaoRecebida(int ligacaoRecebida) {
        this.ligacaoRecebida = ligacaoRecebida;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    


     public static List<Nivel> obterNiveis() throws ClassNotFoundException, SQLException {
        return NivelDAO.obterNiveis();
    }
      public static Nivel obterNivel(int id) throws ClassNotFoundException {
         return NivelDAO.obterNivel(id);
    }
      public void gravar() throws SQLException, ClassNotFoundException{
        NivelDAO.gravar(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
         NivelDAO.alterar(this);
    }
        public void excluir() throws SQLException, ClassNotFoundException {
         NivelDAO.excluir(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + this.configuracao;
        hash = 19 * hash + this.usuario;
        hash = 19 * hash + this.nivel;
        hash = 19 * hash + this.produto;
        hash = 19 * hash + this.relatorio;
        hash = 19 * hash + this.formaPagamento;
        hash = 19 * hash + this.ligacaoRecebida;
        hash = 19 * hash + this.pedido;
        hash = 19 * hash + this.cliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nivel other = (Nivel) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.configuracao != other.configuracao) {
            return false;
        }
        if (this.usuario != other.usuario) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        if (this.produto != other.produto) {
            return false;
        }
        if (this.relatorio != other.relatorio) {
            return false;
        }
        if (this.formaPagamento != other.formaPagamento) {
            return false;
        }
        if (this.ligacaoRecebida != other.ligacaoRecebida) {
            return false;
        }
        if (this.pedido != other.pedido) {
            return false;
        }
        if (this.cliente != other.cliente) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
        
        
           @Override
    public String toString() {
        return "model.Nivel[ id=" + id + " ]";
    }
}
