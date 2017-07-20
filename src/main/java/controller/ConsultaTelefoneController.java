package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.TelefoneDAO;
import model.Telefone;

@Named
@ViewScoped
public class ConsultaTelefoneController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.telefones = TelefoneDAO.getInstance().getAllTelefones();
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String incluir() {
		return "inclusao-telefone.xhtml";
	}
	
	public void excluir(Telefone telefone) {
		TelefoneDAO.getInstance().excluir(telefone);
		init();
	}

}