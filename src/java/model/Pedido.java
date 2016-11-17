/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PedidoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sujajeb
 */
public class Pedido {
    
    private int id;
    private String hora;
    private String data_2;
    private float total;
    private Cliente cliente;
    private int idCliente;
    private Usuario usuario;
    private int idUsuario;
    private FormaPagamento formaPgto;
    private int idFormaPgto;

    public Pedido(int id, String hora, String data, float total,  Cliente cliente, int idCliente, Usuario usuario, int idUsuario, FormaPagamento formaPgto, int idFormaPgto) {
        this.id = id;
        this.hora = hora;
        this.data_2 = data;
        this.total = total;        
        this.cliente = cliente;
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.idUsuario = idUsuario;
        this.formaPgto = formaPgto;
        this.idFormaPgto=idFormaPgto;        
    }
    public Pedido() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData_2() {
        return data_2;
    }

    public void setData_2(String data_2) {
        this.data_2 = data_2;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
  
    public Cliente getCliente() throws ClassNotFoundException, SQLException {
         if((this.cliente == null)&&(this.idCliente != 0)){
        cliente= Cliente.obterCliente(this.idCliente);        
    }
         return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Usuario getUsuario() throws ClassNotFoundException, SQLException {
         if((this.usuario == null)&&(this.idUsuario != 0)){
        usuario= Usuario.obterUsuario(this.idUsuario);        
    }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public FormaPagamento getFormaPgto() throws ClassNotFoundException, SQLException {
         if((this.formaPgto == null)&&(this.idFormaPgto != 0)){
        formaPgto= FormaPagamento.obterFormaPagamento(this.idFormaPgto);        
    }        
        return formaPgto;
    }

    public void setFormaPgto(FormaPagamento formaPgto) {
        this.formaPgto = formaPgto;
    }

    public int getIdFormaPgto() {
        return idFormaPgto;
    }

    public void setIdFormaPgto(int idFormaPgto) {
        this.idFormaPgto = idFormaPgto;
    }
public static List<Pedido> obterPedidos() throws ClassNotFoundException, SQLException {
        return PedidoDAO.obterPedidos();
    }
public static Pedido obterPedido(int id) throws ClassNotFoundException, SQLException {
        return PedidoDAO.obterPedido(id);
}
    public void gravar() throws SQLException, ClassNotFoundException {
         PedidoDAO.gravar(this);
    }
}
