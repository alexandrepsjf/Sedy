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
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String forma;
    private Long id;

    public FormaPagamento(Long id, String forma) {
        this.forma = forma;
        this.id = id;
    }

    public FormaPagamento() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.forma);
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
