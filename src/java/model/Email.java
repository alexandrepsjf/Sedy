/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EmailDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class Email {

    
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
}
    
