/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ListaProdutosDAO;
import java.sql.SQLException;

/**
 *
 * @author Sujajeb
 */
public class ListaProdutos {

   
   

    private int id;
    private int idPedido;
    private int idLista;
    private Produto produto;
    private int idProduto;
    private int quantidade;

    public ListaProdutos() {
    }

    public ListaProdutos(int id, int idPedido, int idLista,  int idProduto, int quantidade) {
        this.id = id;
        this.idPedido = idPedido;
        this.idLista = idLista;
        this.produto = produto;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

   

    public Produto getProduto() throws ClassNotFoundException, SQLException {
        if ((this.produto == null) && (this.idProduto != 0)) {
            produto = Produto.obterProduto(this.idProduto);
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 public static Object obterListaProdutos(int id) throws ClassNotFoundException, SQLException {
      return  ListaProdutosDAO.obterListaProdutos(id);
    }
  public static Object obterListaProdutos() throws ClassNotFoundException {
        return  ListaProdutosDAO.obterListaProdutos();
    }

}
