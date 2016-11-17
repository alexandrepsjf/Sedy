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
import model.Cliente;
import model.ListaProdutos;

/**
 *
 * @author Mateu
 */
public class ListaProdutosDAO {

    public static List<ListaProdutos> obterListasProdutos(id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ListaProdutos> listasProdutos = new ArrayList<ListaProdutos>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from ListaProdutos where id="+id);
            while (rs.next()) {
                ListaProdutos listaProdutos = new ListaProdutos(rs.getInt("ID"), rs.getInt("pedido_id"), rs.getInt("produto_id"), rs.getInt("QUANTIDADE"));
                listaProdutos.setIdPedido(rs.getInt("PEDIDO_ID"));
                listaProdutos.setIdProduto(rs.getInt("PRODUTO_ID"));
                listaProdutos.setId(rs.getInt("ID"));
                listaProdutos.setProduto(listaProdutos.getProduto());
                listasProdutos.add(listaProdutos);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return listasProdutos;
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

    public static List<ListaProdutos> obterListaProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void gravar(ListaProdutos aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Cliente obterCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void alterar(ListaProdutos aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void excluir(ListaProdutos aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<ListaProdutos> obterListasProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ListaProdutos obterListaProdutos(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
