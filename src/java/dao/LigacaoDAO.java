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
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Ligacao;

public class LigacaoDAO {

    public static List<Ligacao> obterLigacao() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Ligacao> ligacoes = new ArrayList<Ligacao>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from ligacao");
            while (rs.next()) {
                Ligacao ligacao = new Ligacao(rs.getInt("ID"),
                        rs.getString("LIGACAO"));                
                ligacoes.add(ligacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return ligacoes;
    }

    public static Ligacao obterLigacao(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Ligacao cliente = new Ligacao();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from ligacao where id = " + id);
            rs.first();
            cliente.setId(rs.getInt("id"));
            cliente.setLigacao(rs.getInt("ligacao"));
            

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return ligacao;
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
    
    public static void gravar(Ligacao ligacao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;

        try {
            conexao = BD.getConexao();
            String sql = "insert into cliente(id,ligacao) values(?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, ligacao.getId());
            comando.setString(2, ligacao.getLigacao());
            
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static void alterar(Ligacao ligacao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;

        try {
            conexao = BD.getConexao();
            String sql = "update ligacao set nome=?,where id=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, ligacao.getLigacao());
            comando.setInt(2, ligacao.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static void excluir(Ligacao ligacao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from  ligacao  where id=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, ligacao.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    
}
    

