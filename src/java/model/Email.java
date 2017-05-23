/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EmailDAO;
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
 * @author Alexandre
 */
@Entity
public class Email implements Serializable{
    private static final long serialVersionUID = 1L;
 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int id;
    private String email;
    private String senha;
    private String autentica;
    private String servidorSaida;
    private String servidorEntrada;

    public Email(int id, String email, String senha, String autentica, String servidorSaida, String servidorEntrada) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.autentica = autentica;
        this.servidorSaida = servidorSaida;
        this.servidorEntrada = servidorEntrada;
    }

    public Email() {
        }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.senha);
        hash = 23 * hash + Objects.hashCode(this.autentica);
        hash = 23 * hash + Objects.hashCode(this.servidorSaida);
        hash = 23 * hash + Objects.hashCode(this.servidorEntrada);
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
        final Email other = (Email) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.autentica, other.autentica)) {
            return false;
        }
        if (!Objects.equals(this.servidorSaida, other.servidorSaida)) {
            return false;
        }
        if (!Objects.equals(this.servidorEntrada, other.servidorEntrada)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Email{" + "id=" + id + ", email=" + email + ", senha=" + senha + ", autentica=" + autentica + ", servidorSaida=" + servidorSaida + ", servidorEntrada=" + servidorEntrada + '}';
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAutentica() {
        return autentica;
    }

    public void setAutentica(String autentica) {
        this.autentica = autentica;
    }

    public String getServidorSaida() {
        return servidorSaida;
    }

    public void setServidorSaida(String servidorSaida) {
        this.servidorSaida = servidorSaida;
    }

    public String getServidorEntrada() {
        return servidorEntrada;
    }

    public void setServidorEntrada(String servidorEntrada) {
        this.servidorEntrada = servidorEntrada;
    }
    public static List<Email> obterEmail() throws ClassNotFoundException, SQLException {
        return EmailDAO.obterEmails();
    }
    public void gravar() throws SQLException, ClassNotFoundException{
        EmailDAO.gravar(this);
    }
    
   public static Email obterEmail(int id) throws ClassNotFoundException, SQLException {
        return EmailDAO.obterEmail(id);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
         EmailDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
         EmailDAO.excluir(this);
    }
    
}
    
