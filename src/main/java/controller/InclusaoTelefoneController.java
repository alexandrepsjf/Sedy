package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.ClienteDAO;
import dao.TelefoneDAO;
import model.Cliente;
import model.Telefone;

@Named
@ViewScoped
public class InclusaoTelefoneController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Telefone telefone;

	private Integer clienteId;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.telefone = TelefoneDAO.getInstance().getTelefone(new Integer(paramId));
			this.clienteId = telefone.getClienteId();
		}else{
			this.telefone = new Telefone();
		}
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String voltar() {
		return "consulta-telefone.xhtml";
	}

	public String salvar() {
		this.telefone.setClienteId(this.clienteId);
		if(this.telefone.getId() == null) {
			TelefoneDAO.getInstance().salvar(telefone);
		} else {
			TelefoneDAO.getInstance().alterar(telefone);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-telefone.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public List<Cliente> getClientes() {
		return ClienteDAO.getInstance().getAllCliente();
	}

}