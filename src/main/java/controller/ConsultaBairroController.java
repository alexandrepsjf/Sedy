package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.BairroDAO;
import model.Bairro;

@Named
@ViewScoped
public class ConsultaBairroController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Bairro> bairros = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.bairros = BairroDAO.getInstance().getAllBairros();
	}

	public String incluir() {
		return "inclusao-bairro.xhtml";
	}
	
	public void excluir(Bairro bairro) {
		BairroDAO.getInstance().excluir(bairro);
		init();
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	
}