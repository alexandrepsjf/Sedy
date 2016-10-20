/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Bairro;
import java.util.ArrayList;
import javax.servlet.ServletException;

public class BairroDAO {

    public static List<Bairro> obterBairros() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Bairro> bairros = new ArrayList<Bairro>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from bairro");
            while (rs.next()) {
                Bairro bairro = new Bairro(rs.getInt("ID"),
                        rs.getString("BAIRRO"),
                        rs.getFloat("TAXA"));
                bairros.add(bairro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return bairros;
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

    public static void gravar(Bairro bairro) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into bairro(id,nome,taxa) values(?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, bairro.getId());
            comando.setString(2, bairro.getNome());
            comando.setFloat(3, bairro.getTaxa());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
