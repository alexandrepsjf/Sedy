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

    public static List<Email> obterEmails() throws ClassNotFoundException, SQLException {
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

    public static Email obterEmail(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Email email = new Email();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from email where id = " + id);
            rs.first();
            email.setId(rs.getInt("ID"));
            email.setEmail(rs.getString("email"));
            email.setSenha(rs.getString("senha"));
            email.setAutentica(rs.getString("autentica"));
            email.setServidorSaida(rs.getString("servidorSaida"));
            email.setServidorEntrada(rs.getString("servidorEntrada"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return email;
    }

    public static void alterar(Email email) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = " update email set email = ?,  senha = ?, autentica = ? , servidorSaida = ? , servidorEntrada = ?  where id = ? ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, email.getEmail());
            comando.setString(2, email.getSenha());
            comando.setString(3, email.getAutentica());
            comando.setString(4, email.getServidorSaida());
            comando.setString(5, email.getServidorEntrada());
            comando.setInt(6, email.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }}
