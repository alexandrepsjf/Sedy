/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ProdutoDAO;
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
public class Produto implements Serializable{
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Produto() {
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
    public static List<Produto> obterProdutos() throws ClassNotFoundException, SQLException {
        return ProdutoDAO.obterProdutos();
    }
    public void gravar() throws SQLException, ClassNotFoundException{
        ProdutoDAO.gravar(this);
    }
    public static Produto obterProduto(int id) throws ClassNotFoundException, SQLException{
        return ProdutoDAO.obterProduto(id);
    }
        public void excluir() throws SQLException, ClassNotFoundException {
         ProdutoDAO.excluir(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        ProdutoDAO.alterar(this);
    }
    
    
            @Override
    public String toString() {
        return "model.Produto[ id=" + id + " ]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.unidade);
        hash = 11 * hash + Float.floatToIntBits(this.valor);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        return true;
    }
}
