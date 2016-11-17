/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class ListaProdutos {

    private int quantitade;
    private int idPedido;
    private int idProduto;
    private Produto produto;

    public ListaProdutos() {
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
         if((this.produto == null)&&(this.idProduto != 0)){
        produto= Produto.obterProduto(this.idProduto);
    }
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
