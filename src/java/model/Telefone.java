/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.TelefoneDAO;
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
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String numero;
      private Cliente cliente;

    public Telefone(int id, String telefone) {
        this.id = id;
        this.numero = telefone;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.numero);
        hash = 13 * hash + Objects.hashCode(this.cliente);
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
        final Telefone other = (Telefone) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "id=" + id + ", numero=" + numero + ", cliente=" + cliente + '}';
    }

    public Cliente getCliente() {
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
