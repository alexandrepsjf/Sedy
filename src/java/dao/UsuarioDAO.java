/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
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
            ResultSet rs = comando.executeQuery("select*from usuario");
            while (rs.next()) {
                Usuario usuario = new Usuario (rs.getInt("ID"),rs.getString("USUARIO"),rs.getString("SENHA"), rs.getString("LOGIN"), null,0);
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
}
