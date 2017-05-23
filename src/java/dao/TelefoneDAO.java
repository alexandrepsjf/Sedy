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
import java.util.List;
import java.util.ArrayList;
import model.Telefone;

public class TelefoneDAO {

    public static List<Telefone> obterTelefones() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Telefone> telefones = new ArrayList<Telefone>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from telefone");
            while (rs.next()) {
                Telefone telefone = new Telefone(rs.getInt("ID"),
                        rs.getString("TELEFONE")
                );
                telefone.setIdCliente(rs.getInt("CLIENTE_ID"));
                telefone.setCliente(telefone.getCliente());
                telefones.add(telefone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return telefones;
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

    public static void gravar(Telefone telefone) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into telefone(id,telefone,cliente_id) values(?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, telefone.getId());
            comando.setString(2, telefone.getNumero());
            comando.setFloat(3, telefone.getIdCliente());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }

    }

    public static Telefone obterTelefone(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Telefone telefone = new Telefone();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from telefone where id = " + id);
            rs.first();
            telefone.setId(rs.getInt("ID"));
            telefone.setNumero(rs.getString("telefone"));
            telefone.setIdCliente(rs.getInt("cliente_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return telefone;
    }

    public static void alterar(Telefone telefone) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update telefone set telefone=?,cliente_id=?  where id=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, telefone.getNumero());
            comando.setFloat(2, telefone.getIdCliente());
            comando.setInt(3, telefone.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Telefone telefone) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from telefone where id =  ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, telefone.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
