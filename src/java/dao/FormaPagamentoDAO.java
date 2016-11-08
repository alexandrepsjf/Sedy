/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Sujajeb
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import model.FormaPagamento;

public class FormaPagamentoDAO {

    public static List<FormaPagamento> obterFormasPagamento() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<FormaPagamento> formaspagamento = new ArrayList<FormaPagamento>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from forma_pgm");
            while (rs.next()) {
                FormaPagamento formapagamento = new FormaPagamento(rs.getInt("ID"),
                        rs.getString("FORMA"));
                formaspagamento.add(formapagamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return formaspagamento;
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
        public static void gravar(FormaPagamento formapagamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into forma_pgm(id,forma) values(?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, formapagamento.getId());
            comando.setString(2, formapagamento.getForma());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

        public static FormaPagamento obterFormaPagamento(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        FormaPagamento formapagamento = new FormaPagamento();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from forma_pgm where id = " + id);
            rs.first();
           formapagamento.setId(rs.getInt("ID"));
           formapagamento.setForma(rs.getString("FORMA"));
                        
            

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
    return formapagamento;    
    }

    public static void excluir(FormaPagamento formapagamento) throws ClassNotFoundException, SQLException {
       Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from forma_pgm where id = ? ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, formapagamento.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(FormaPagamento formapagamento) throws ClassNotFoundException, SQLException {
       Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update forma_pgm set  forma = ? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
           comando.setInt(2, formapagamento.getId());
            comando.setString(1, formapagamento.getForma());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
   
}
