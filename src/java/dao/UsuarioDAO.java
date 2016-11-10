/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Mateu
 */
public class UsuarioDAO {

    public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from usuario");
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("ID"), rs.getString("USUARIO"), rs.getString("SENHA"), rs.getString("LOGIN"), null, 0);
                usuario.setIdNivel(rs.getInt("NIVEL_ID"));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return usuarios;
    }

    public static Usuario obterUsuario(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Usuario usuario = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from usuario where id = " + id);
            rs.first();
            usuario = new Usuario(rs.getInt("ID"), rs.getString("USUARIO"), rs.getString("SENHA"), rs.getString("LOGIN"), null, 0);
            usuario.setIdNivel(rs.getInt("NIVEL_ID"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return usuario;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {

        }
    }

    public static void gravar(Usuario usuario) throws ClassNotFoundException, SQLException {
         Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into usuario(id,usuario, senha,login,nivel_id) values(?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, usuario.getId());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getLogin());
            comando.setString(2, usuario.getUsuario());
            comando.setInt(5, usuario.getIdNivel());           
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    

    public static void alterar(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update usuario set usuario = ? , senha = ? , login = ? , nivel = ?,  where id = ? ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, usuario.getUsuario());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getLogin());
            comando.setInt(4, usuario.getIdNivel());
            comando.setInt(5, usuario.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    public static void excluir (Usuario usuario)throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        
    try{
        conexao = BD.getConexao();
            String sql = "delete from usuario  where id = ? ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, usuario.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
