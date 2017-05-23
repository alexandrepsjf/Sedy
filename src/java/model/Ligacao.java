/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.LigacaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class Ligacao {
    private int id;
    private String telefone;
    private Cliente cliente;
    private int idCliente;

    public Ligacao(int id, String telefone, Cliente cliente, int idCliente) {
        this.id = id;
        this.telefone = telefone;
        this.cliente = cliente;
        this.idCliente = idCliente;
    }

    public Ligacao(int id, String telefone) {
        this.id = id;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public static List<Ligacao> obterLigacao() throws ClassNotFoundException, SQLException {
        return LigacaoDAO.obterLigacao();
    }
}
