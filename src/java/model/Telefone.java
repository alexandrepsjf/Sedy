/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
    private Long id;
    private String numero;
      private Cliente cliente;

    public Telefone(Long id, String telefone, String numero, String cliente) {
        this.id = id;
        this.numero = telefone;

    }

    public Telefone(String numero, String cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.numero);
        hash = 19 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCliente(String cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}
