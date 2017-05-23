/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FormaPagamentoDAO;
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
public class FormaPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private String forma;    
    private int id;
    public FormaPagamento(int id,String forma ) {
        this.forma = forma;
        this.id = id;
    }

    public FormaPagamento() {
        }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.forma);
        hash = 47 * hash + this.id;
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
        final FormaPagamento other = (FormaPagamento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.forma, other.forma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" + "forma=" + forma + ", id=" + id + '}';
    }
    
 
    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static List<FormaPagamento> obterFormasPagamento() throws ClassNotFoundException, SQLException {
        return FormaPagamentoDAO.obterFormasPagamento();
    }
    public void gravar() throws SQLException, ClassNotFoundException{
        FormaPagamentoDAO.gravar(this);
    }
     public static FormaPagamento obterFormaPagamento(int id)throws ClassNotFoundException, SQLException {
         return FormaPagamentoDAO.obterFormaPagamento(id);
     }

    public void excluir() throws ClassNotFoundException, SQLException {
        FormaPagamentoDAO.excluir(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        FormaPagamentoDAO.alterar(this);
    }

   
}
