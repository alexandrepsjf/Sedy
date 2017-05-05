/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class Telefone {

    private int id;
    private String numero;
    private int idCliente;
    private Cliente cliente;

    public Telefone(int id, String telefone) {
        this.id = id;
        this.numero = telefone;

    }

    public Cliente getCliente() throws ClassNotFoundException, SQLException {
        if ((this.cliente == null) && (this.idCliente != 0)) {
            cliente = Cliente.obterCliente(this.idCliente);
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Telefone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public static List<Telefone> obterTelefones() throws ClassNotFoundException, SQLException {
        return TelefoneDAO.obterTelefones();
    }

    public static Telefone obterTelefone(int id) throws ClassNotFoundException {
        return TelefoneDAO.obterTelefone(id);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        TelefoneDAO.gravar(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        TelefoneDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        TelefoneDAO.excluir(this);
    }

}
