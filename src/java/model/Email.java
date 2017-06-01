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
 * @author Alexandre
 */
@Entity
public class Email implements Serializable{
    private static final long serialVersionUID = 1L;
 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    private String email;
    private String senha;
    private String autentica;
    private String servidorSaida;
    private String servidorEntrada;

    public Email(Long id, String email, String senha, String autentica, String servidorSaida, String servidorEntrada) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.autentica = autentica;
        this.servidorSaida = servidorSaida;
        this.servidorEntrada = servidorEntrada;
    }

    public Email(String email, String senha) {
        this.email = email;
        this.senha = senha;
        }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.email);
        hash = 61 * hash + Objects.hashCode(this.senha);
        hash = 61 * hash + Objects.hashCode(this.autentica);
        hash = 61 * hash + Objects.hashCode(this.servidorSaida);
        hash = 61 * hash + Objects.hashCode(this.servidorEntrada);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String emails) {
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
   
    
}
    
