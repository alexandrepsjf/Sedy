/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.LigacaoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sujajeb
 */
@Entity
public class Ligacao implements Serializable {
    private static final long serialVersionUID = 1L;
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id;
    private String telefone;
    @ManyToOne
    private Cliente cliente;

    public Ligacao() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
  

    public Ligacao(int id, String telefone, Cliente cliente) {
        this.id = id;
        this.telefone = telefone;
        this.cliente = cliente;
       
    }

    public Ligacao(int id, String telefone) {
        this.id = id;
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.telefone);
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
        final Ligacao other = (Ligacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ligacao{" + "id=" + id + ", telefone=" + telefone + ", cliente=" + cliente + '}';
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

   
  
    public static List<Ligacao> obterLigacao() throws ClassNotFoundException, SQLException {
        return LigacaoDAO.obterLigacao();
    }
}
