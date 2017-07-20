package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.LigacaoDAO;
import model.Ligacoes;

@Named
@ViewScoped
public class ConsultaLigacoesController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Ligacoes> ligacoes = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.ligacoes = LigacaoDAO.getInstance().getAllLigacao();
	}

	public String incluir() {
		return "inclusao-ligacao.xhtml";
	}
	
	public void excluir(Ligacoes ligacao) {
		LigacaoDAO.getInstance().excluir(ligacao);
		init();
	}

	public List<Ligacoes> getLigacoes() {
		return ligacoes;
	}

	public void setLigacoes(List<Ligacoes> ligacoes) {
		this.ligacoes = ligacoes;
	}

	
}