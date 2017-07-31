package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.PedidoDAO;
import model.Pedido;

@Named
@ViewScoped
public class ConsultaPedidoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Pedido> registros = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.registros = PedidoDAO.getInstance().getAllPedidos();
	}

	public String incluir() {
		return "inclusao-pedido.xhtml";
	}
	
	public void excluir(Pedido reg) {
		PedidoDAO.getInstance().excluir(reg);
		init();
	}

        public List<Pedido> getRegistros() {
            return registros;
        }

        public void setRegistros(List<Pedido> registros) {
            this.registros = registros;
        }
	
}