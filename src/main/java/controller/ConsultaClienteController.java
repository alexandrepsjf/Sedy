package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.ClienteDAO;
import model.Cliente;

@Named
@ViewScoped
public class ConsultaClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Cliente> clientes = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.clientes = ClienteDAO.getInstance().getAllCliente();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public String incluir() {
		return "inclusao-cliente.xhtml";
	}
	
	public void excluir(Cliente cliente) {
		ClienteDAO.getInstance().excluir(cliente);
	}

}