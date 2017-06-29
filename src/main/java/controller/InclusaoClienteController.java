package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.BairroDAO;
import dao.ClienteDAO;
import model.Bairro;
import model.Cliente;

@Named
@ViewScoped
public class InclusaoClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	private Integer bairroId;
	
	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String voltar() {
		return "consulta-clientes.xhtml";
	}
	
	public List<Bairro> getBairros(){
		return BairroDAO.getInstance().getAllBairros();
	}
	
	public Integer getBairroId() {
		return bairroId;
	}

	public void setBairroId(Integer bairroId) {
		this.bairroId = bairroId;
	}

	public String salvar() {
		this.cliente.setBairroId(BairroDAO.getInstance().getBairro(bairroId));
		ClienteDAO.getInstance().salvar(cliente);
		return "";
	}
	
}