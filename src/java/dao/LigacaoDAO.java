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
import java.util.List;
import java.util.ArrayList;
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
                        rs.getString("TELEFONE"));                
                ligacoes.add(ligacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return ligacoes;
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

