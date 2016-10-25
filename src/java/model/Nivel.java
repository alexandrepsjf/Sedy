/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.NivelDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class Nivel {
     private int id;
    private String nome;
    private boolean configuracao;
    private boolean usuario;
    private boolean nivel;
    private boolean produto;
    private boolean relatorio;
    private boolean formaPagamento;
    private boolean ligacaoRecebida;
    private boolean pedido;
    private boolean cliente;

    public Nivel(int id, String nome, boolean configuracao, boolean usuario, boolean nivel, boolean produto, boolean relatorio, boolean formaPagamento, boolean ligacaoRecebida, boolean pedido, boolean cliente) {
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
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(boolean configuracao) {
        this.configuracao = configuracao;
    }

    public boolean isUsuario() {
        return usuario;
    }

    public void setUsuario(boolean usuario) {
        this.usuario = usuario;
    }

    public boolean isNivel() {
        return nivel;
    }

    public void setNivel(boolean nivel) {
        this.nivel = nivel;
    }

    public boolean isProduto() {
        return produto;
    }

    public void setProduto(boolean produto) {
        this.produto = produto;
    }

    public boolean isRelatorio() {
        return relatorio;
    }

    public void setRelatorio(boolean relatorio) {
        this.relatorio = relatorio;
    }

    public boolean isFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(boolean formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isLigacaoRecebida() {
        return ligacaoRecebida;
    }

    public void setLigacaoRecebida(boolean ligacaoRecebida) {
        this.ligacaoRecebida = ligacaoRecebida;
    }

    public boolean isPedido() {
        return pedido;
    }

    public void setPedido(boolean pedido) {
        this.pedido = pedido;
    }

    public boolean isCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public static List<Nivel> obterNivel() throws ClassNotFoundException, SQLException {
        return NivelDAO.obterNivel();
    }
      public void gravar() throws SQLException, ClassNotFoundException{
        NivelDAO.gravar(this);
    }
}
