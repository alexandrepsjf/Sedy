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
                Nivel nivel = new Nivel(rs.getInt("ID"),rs.getString("nome"),true,true,true,true,true,true,true,true,true);
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

}
