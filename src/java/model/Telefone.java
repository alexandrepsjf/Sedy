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
    private String telefone;
    private Cliente cliente ;
    private int idCliente;

    public Telefone(int id, String telefone, Cliente cliente, int idCliente) {
        this.id = id;
        this.telefone = telefone;
        this.cliente = cliente;
        this.idCliente = idCliente;
    }

    public Telefone(int id, String telCliente, int idCliente) {
        this.id=id;
        this.idCliente=idCliente;
        this.telefone=telCliente;
    }

    public Telefone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

}
