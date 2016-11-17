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
import model.Cliente;

/**
 *
 * @author Sujajeb
 */
public class ClienteDAO {

    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("NOME"),
                        rs.getString("RUA"),
                        rs.getString("NUMERO"),
                        rs.getString("CEP"),
                        rs.getString("DATA_CADASTRO"),
                        rs.getString("hora_CADASTRO"),
                        rs.getString("EMAIL"),
                        rs.getString("REFERENCIA_ENDERECO"),
                        null, 
                        rs.getInt("BAIRRO_ID"));
                cliente.setBairro(cliente.getBairro());                
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return clientes;
    }

    public static Cliente obterCliente(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = new Cliente();        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from cliente where id = " + id);
            rs.first();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setRua(rs.getString("RUA"));
            cliente.setNumero(rs.getString("NUMERO"));
            cliente.setCep(rs.getString("CEP"));
            cliente.setDataCadastro(rs.getString("DATA_CADASTRO"));
            cliente.setDataCadastro(rs.getString("HORA_CADASTRO"));
            cliente.setEmail(rs.getString("EMAIL"));
            cliente.setReferenciaEndereco(rs.getString("REFERENCIA_ENDERECO"));
            cliente.setIdBairro(rs.getInt("BAIRRO_ID"));
            cliente.setBairro(cliente.getBairro());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cliente;
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

    public static void gravar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
            
        try {
            conexao = BD.getConexao();
            String sql = "insert into cliente(id,nome,rua, numero, cep, data_cadastro, hora_cadastro, email, referencia_endereco, bairro_id) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, cliente.getId());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getRua());
            comando.setString(4, cliente.getNumero());
            comando.setString(5, cliente.getCep());
            comando.setString(6, cliente.getDataCadastro());
            comando.setString(7, cliente.getHoraCadastro());
            comando.setString(8, cliente.getEmail());
            comando.setString(9, cliente.getReferenciaEndereco());
            comando.setInt(10, cliente.getIdBairro());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
            
        try {
            conexao = BD.getConexao();
            String sql = "update cliente set nome=?,rua=?, numero=?, cep=?, data_cadastro=?, hora_cadastro=?, email=?, referencia_endereco=?, bairro_id=? where id=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
                        comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getRua());
            comando.setString(3, cliente.getNumero());
            comando.setString(4, cliente.getCep());
            comando.setString(5, cliente.getDataCadastro());
            comando.setString(6, cliente.getHoraCadastro());
            comando.setString(7, cliente.getEmail());
            comando.setString(8, cliente.getReferenciaEndereco());
            comando.setInt(9, cliente.getIdBairro());
            comando.setInt(10, cliente.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
