/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class Usuario {
    private int id;
    private String usuario;
    private String senha;
    private String login;
    private Nivel nivel;
    private int idNivel;

    public Usuario(int id, String usuario, String senha, String login, Nivel nivel, int idNivel) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.login = login;
        this.nivel = nivel;
        this.idNivel = idNivel;
    }

    public Usuario(int aInt, String string, Object object, int i, String string0, Object object0, int i0, String string1, Object object1, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }
     public static List<Usuario> obterUsuario() throws ClassNotFoundException, SQLException {
        return UsuarioDAO.obterUsuarios();
    }
}
