/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class Cliente {
    private int id;
    private String nome;
    private String rua;
    private String numero;    
    private String cep;    
    private String dataCadastro;
    private String email;
    private String referenciaEndereco;
    private Bairro bairro;
    private int idBairro;
public Cliente(int id, String nome, String rua, String numero, String cep, String dataCadastro, String email, String referenciaEndereco, Bairro bairro, int idBairro) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.dataCadastro = dataCadastro;
        this.email = email;
        this.referenciaEndereco = referenciaEndereco;
        this.bairro = bairro;
        this.idBairro = idBairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferenciaEndereco() {
        return referenciaEndereco;
    }

    public void setReferenciaEndereco(String referenciaEndereco) {
        this.referenciaEndereco = referenciaEndereco;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }
    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterClientes();
    }
    
    
}
