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
    private String horaCadastro;
    private String referenciaEndereco;
    private Bairro bairro;
    private int idBairro;
public Cliente(int id, String nome, String rua, String numero, String cep, String dataCadastro, String horaCadastro, String email, String referenciaEndereco, Bairro bairro, int idBairro) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.dataCadastro = dataCadastro;
        this.horaCadastro = horaCadastro;
        this.email = email;
        this.referenciaEndereco = referenciaEndereco;
        this.bairro = bairro;
        this.idBairro = idBairro;
    }

    public Cliente() {
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

    public String getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(String horaCadastro) {
        this.horaCadastro = horaCadastro;
    }
    public void setReferenciaEndereco(String referenciaEndereco) {
        this.referenciaEndereco = referenciaEndereco;
    }

    public Bairro getBairro() throws ClassNotFoundException, SQLException {
        if((this.bairro == null)&&(this.idBairro != 0)){
        bairro= Bairro.obterBairro(this.idBairro);
    }
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
     public void gravar() throws SQLException, ClassNotFoundException{
        ClienteDAO.gravar(this);
    }
    public static Cliente obterCliente(int id) throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterCliente(id);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
         ClienteDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
         ClienteDAO.excluir(this);
    }
}
