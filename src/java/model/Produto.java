/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class Produto {
    private int id;
    private String nome;
    private String unidade;
    private float valor;

    public Produto(int id, String nome, String unidade, float valor) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.valor = valor;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setValor(float valor){
        this.valor=valor;
    }
    public float getValor(){
        return this.valor;
    }
    public void setUnidade(String unidade){
        this.unidade=unidade;
    }
    public String getUnidade(){
        return this.unidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static List<Produto> obterProduto() throws ClassNotFoundException, SQLException {
        return ProdutoDAO.obterProduto();
    }
    public void gravar() throws SQLException, ClassNotFoundException{
        ProdutoDAO.gravar(this);
    }
}
