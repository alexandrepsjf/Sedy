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
import model.Pedido;

public class PedidoDAO {

    public static List<Pedido> obterPedidos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from pedido");
            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("ID"),
                        rs.getString("HORA"),
                        rs.getString("DATA_2"),
                        rs.getFloat("TOTAL"),
                        null,
                        rs.getInt("CLIENTE_ID"),
                        null,
                        rs.getInt("USUARIO_ID"),
                        null,
                        rs.getInt("FORMA_PGM_ID"));
                pedido.setCliente(pedido.getCliente());
                pedido.setFormaPgto(pedido.getFormaPgto());
                pedido.setUsuario(pedido.getUsuario());
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return pedidos;
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

    public static void gravar(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into pedido(id,data_2,hora,cliente_id,forma_pgm_id,usuario_id,total) values(?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, pedido.getId());
            comando.setString(2, pedido.getData_2());
            comando.setString(3, pedido.getHora());
            comando.setInt(4, pedido.getIdCliente());
            comando.setInt(5, pedido.getIdFormaPgto());
            comando.setInt(6, pedido.getIdUsuario());
            comando.setFloat(7, pedido.getTotal());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

}
