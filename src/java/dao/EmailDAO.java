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
import model.Email;

public class EmailDAO {

    public static List<Email> obterEmail() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Email> emails = new ArrayList<Email>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from email");
            while (rs.next()) {
                Email email = new Email(rs.getInt("ID"),
                rs.getString("EMAIL"),
                rs.getString("SENHA"),
                rs.getString("AUTENTICA"),
                rs.getString("servidorSaida"),
                rs.getString("servidorEntrada"));
               emails.add(email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return emails;
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

        public static void gravar(Email email) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into email(id,email,senha,autentica,servidorSaida,servidorEntrada) values(?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, email.getId());
            comando.setString(2, email.getEmail());
            comando.setString(3, email.getSenha());
            comando.setString(4, email.getAutentica());
            comando.setString(5, email.getServidorSaida());
            comando.setString(6, email.getServidorEntrada());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
