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
}
