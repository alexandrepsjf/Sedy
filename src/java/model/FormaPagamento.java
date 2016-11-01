/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FormaPagamentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class FormaPagamento {

   
    private String forma;    
    private int id;
    public FormaPagamento(int id,String forma ) {
        this.forma = forma;
        this.id = id;
    }

    public FormaPagamento() {
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
}
