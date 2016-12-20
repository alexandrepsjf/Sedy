/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ListaProdutosDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class ListaProdutos {

   

    private int id;
    private int quantitade;
    private int idPedido;
    private int idProduto;
    private Produto produto;

    public ListaProdutos() {
    }

    public ListaProdutos(int id, int quantitade, int idPedido, int idProduto) {
        this.id = id;
        this.quantitade = quantitade;
        this.idPedido = idPedido;
        this.idProduto = idProduto;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantitade() {
        return quantitade;
    }

    public void setQuantitade(int quantitade) {
        this.quantitade = quantitade;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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
     public static List<ListaProdutos> obterListaProdutos(int id) throws ClassNotFoundException, SQLException {
        return ListaProdutosDAO.obterListaProdutos(id);
    }
     public void gravar() throws SQLException, ClassNotFoundException{
        ListaProdutosDAO.gravar(this);
    }
    public static ListaProdutos obterListaProduto(int id) throws ClassNotFoundException, SQLException {
        return ListaProdutosDAO.obterListaProduto(id);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
         ListaProdutosDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
         ListaProdutosDAO.excluir(this);
    }
}
