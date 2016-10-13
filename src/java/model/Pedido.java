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
    private String data;
    private float total;
    private String telefone;
    private Cliente cliente;
    private int idCliente;
    private Usuario usuario;
    private int idUsuario;
    private FormaPagamento formaPgto;
    private int idFormaPgto;

    public Pedido(int id, String hora, String data, float total, String telefone, Cliente cliente, int idCliente, Usuario usuario, int idUsuario, FormaPagamento formaPgto, int idFormaPgto) {
        this.id = id;
        this.hora = hora;
        this.data = data;
        this.total = total;
        this.telefone = telefone;
        this.cliente = cliente;
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.idUsuario = idUsuario;
        this.formaPgto = formaPgto;
        this.idFormaPgto=idFormaPgto;
        
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente getCliente() {
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

    public Usuario getUsuario() {
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

    public FormaPagamento getFormaPgto() {
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
public static List<Pedido> obterPedido() throws ClassNotFoundException, SQLException {
        return PedidoDAO.obterPedidos();
    }
}
