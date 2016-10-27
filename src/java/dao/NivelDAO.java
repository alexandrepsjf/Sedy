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
import model.Nivel;

/**
 *
 * @author Sujajeb
 */
public class NivelDAO {

    public static List<Nivel> obterNiveis() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Nivel> niveis = new ArrayList<Nivel>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from nivel");
            while (rs.next()) {
                Nivel nivel = new Nivel(rs.getInt("ID"), rs.getString("NOME"), rs.getInt("configuracao"), rs.getInt("usuario"), rs.getInt("nivel"), rs.getInt("produto"), rs.getInt("relatorio"), rs.getInt("FORMA_PGM"), rs.getInt("LIGACAO_RECEBIDA"), rs.getInt("pedido"), rs.getInt("cliente"));
                niveis.add(nivel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return niveis;
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

    public static void gravar(Nivel nivel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO `nivel`(`ID`, `NOME`, `CONFIGURACAO`, `USUARIO`, `NIVEL`, `PRODUTO`, `RELATORIO`, `FORMA_PGM`, `LIGACAO_RECEBIDA`, `PEDIDO`, `CLIENTE`) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, nivel.getId());
            comando.setString(2, nivel.getNome());
            comando.setInt(3, nivel.getConfiguracao());
            comando.setInt(8, nivel.getFormaPagamento());
            comando.setInt(9, nivel.getLigacaoRecebida());
            comando.setInt(5, nivel.getNivel());
            comando.setInt(10, nivel.getPedido());
            comando.setInt(6, nivel.getProduto());
            comando.setInt(4, nivel.getUsuario());
            comando.setInt(11, nivel.getCliente());
            comando.setInt(7, nivel.getRelatorio());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static Nivel obterNivel(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Nivel nivel = new Nivel();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from nivel where id = " + id);
            rs.first();            
                nivel.setId(rs.getInt("ID"));
                nivel.setNome(rs.getString("NOME"));
                nivel.setConfiguracao(rs.getInt("configuracao"));
                nivel.setUsuario(rs.getInt("usuario"));
                nivel.setNivel(rs.getInt("nivel"));
                nivel.setProduto(rs.getInt("produto"));
                nivel.setRelatorio(rs.getInt("relatorio"));
                nivel.setFormaPagamento(rs.getInt("FORMA_PGM"));
                nivel.setLigacaoRecebida(rs.getInt("LIGACAO_RECEBIDA"));
                nivel.setPedido(rs.getInt("pedido"));
                nivel.setCliente(rs.getInt("cliente"));        

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return nivel;
    }
}
