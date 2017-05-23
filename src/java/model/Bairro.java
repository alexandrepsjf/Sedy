/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BairroDAO;
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
public class Bairro implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;  
    private String nome;
    private float taxa;

    public Bairro(int id, String nome, float taxa) {
        this.id = id;
        this.nome = nome;
        this.taxa = taxa;
    }

    public Bairro() {
        }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public float getTaxa() {
        return this.taxa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Bairro> obterBairros() throws ClassNotFoundException, SQLException {
        return BairroDAO.obterBairros();
    }

    public void gravar() throws SQLException, ClassNotFoundException{
        BairroDAO.gravar(this);
    }
    public static Bairro obterBairro(int id) throws ClassNotFoundException, SQLException {
        return BairroDAO.obterBairro(id);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
         BairroDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
         BairroDAO.excluir(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Float.floatToIntBits(this.taxa);
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
        final Bairro other = (Bairro) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.taxa) != Float.floatToIntBits(other.taxa)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "model.Bairro[ id=" + id + " ]";
    }
}
