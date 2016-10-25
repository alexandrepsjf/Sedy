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
import javax.persistence.Convert;
import model.Nivel;

/**
 *
 * @author Sujajeb
 */
public class NivelDAO {

    public static List<Nivel> obterNivel() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Nivel> niveis = new ArrayList<Nivel>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from nivel");
            while (rs.next()) {
                Nivel nivel = new Nivel(rs.getInt("ID"), rs.getString("NOME"),rs.getBoolean("configuracao"), rs.getBoolean("usuario"), rs.getBoolean("nivel"), rs.getBoolean("produto"), rs.getBoolean("relatorio"), rs.getBoolean("FORMA_PGM"), rs.getBoolean("LIGACAO_RECEBIDA"), rs.getBoolean("pedido"), rs.getBoolean("cliente"));
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
            String sql = "insert into nivel(INSERT INTO `nivel`(`ID`, `NOME`, `CONFIGURACAO`, `USUARIO`, `NIVEL`, `PRODUTO`, `RELATORIO`, `FORMA_PGM`, `LIGACAO_RECEBIDA`, `PEDIDO`, `CLIENTE`) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, nivel.getId());
            comando.setString(2, nivel.getNome());
            comando.setBoolean(3, nivel.isConfiguracao());
            comando.setBoolean(8, nivel.isFormaPagamento());
            comando.setBoolean(9, nivel.isLigacaoRecebida());
            comando.setBoolean(5, nivel.isNivel());
            comando.setBoolean(10, nivel.isPedido());
            comando.setBoolean(6, nivel.isProduto());
            comando.setBoolean(4, nivel.isUsuario());
            comando.setBoolean(11, nivel.isCliente());
            comando.setBoolean(7, nivel.isRelatorio());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
