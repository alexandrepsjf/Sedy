/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsuarioDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
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
public class Usuario  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String senha;
    private String login;
    @ManyToOne
    private Nivel nivel;
    

    public Usuario(int id, String nome, String senha, String login, Nivel nivel) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.nivel = nivel;
      
    }

    public Usuario() {
    }    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

 
     public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException {
        return UsuarioDAO.obterUsuarios();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        UsuarioDAO.gravar(this);
    }
    public static Usuario obterUsuario(int id) throws ClassNotFoundException, SQLException {
        return UsuarioDAO.obterUsuario(id);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
         UsuarioDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
         UsuarioDAO.excluir(this);
    }
    
    
            @Override
    public String toString() {
        return "model.Usuario[ id=" + id + " ]";
    }
}
