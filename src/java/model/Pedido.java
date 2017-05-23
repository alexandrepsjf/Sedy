/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PedidoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sujajeb
 */
@Entity
public class Pedido implements Serializable {
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String hora;
    private String data_2;
    private float total;
     @ManyToOne
    private Cliente cliente;
      @ManyToOne
    private Usuario usuario;
       @ManyToOne
     private FormaPagamento formaPgto;

    public Pedido(int id, String hora, String data, float total, Cliente cliente, Usuario usuario, FormaPagamento formaPgto) {
        this.id = id;
        this.hora = hora;
        this.data_2 = data;
        this.total = total;
        this.cliente = cliente;
        this.usuario = usuario;
        this.formaPgto = formaPgto;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Pedido() {

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.hora);
        hash = 37 * hash + Objects.hashCode(this.data_2);
        hash = 37 * hash + Float.floatToIntBits(this.total);
        hash = 37 * hash + Objects.hashCode(this.cliente);
        hash = 37 * hash + Objects.hashCode(this.usuario);
        hash = 37 * hash + Objects.hashCode(this.formaPgto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.total) != Float.floatToIntBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.data_2, other.data_2)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.formaPgto, other.formaPgto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", hora=" + hora + ", data_2=" + data_2 + ", total=" + total + ", cliente=" + cliente + ", usuario=" + usuario + ", formaPgto=" + formaPgto + '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public FormaPagamento getFormaPgto() {
        return formaPgto;
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFormaPgto(FormaPagamento formaPgto) {
        this.formaPgto = formaPgto;
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

    public void alterar() throws ClassNotFoundException, SQLException {
        PedidoDAO.alterar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        PedidoDAO.excluir(this);
    }
}
