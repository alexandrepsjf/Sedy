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
import model.Pedido;

public class PedidoDAO {
    public static List<Pedido>obterPedidos() throws ClassNotFoundException, SQLException{
    Connection conexao = null;
    Statement comando = null;
    List<Pedido> pedidos = new ArrayList<Pedido>();    
        try {
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select*from pedido");
        while (rs.next()) {
            Pedido pedido = new Pedido
                    (rs.getInt("ID"),rs.getString("HORA"),rs.getString("DATA"),rs.getFloat("TOTAL"),"3232323232",null,0,null,0,null,0);
            pedido.setIdCliente(rs.getInt("CLIENTE_ID"));
            pedido.setIdFormaPgto(rs.getInt("FORMA_PGM_ID"));
            pedido.setIdUsuario(rs.getInt("USUARIO_ID"));
            pedidos.add(pedido);
        }
    

}catch(SQLException e) {
        e.printStackTrace();
    }
    
    finally{
        fecharConexao(conexao, comando);
    }
    return pedidos;
}
public static void fecharConexao(Connection conexao, Statement comando){
    try{
        if(comando!=null){
            comando.close();
        }
        if(conexao!=null){
        conexao.close();
    }
    }catch(SQLException e){
        
    }
}
    
}
