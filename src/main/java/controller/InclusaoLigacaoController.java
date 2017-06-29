package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.LigacaoDAO;
import model.Ligacoes;

@Named
@ViewScoped
public class InclusaoLigacaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ligacoes ligacoes;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.ligacoes = LigacaoDAO.getInstance().getLigacao(new Integer(paramId));
		}else{
			this.ligacoes = new Ligacoes();
		}
	}

	public String voltar() {
		return "consulta-ligacao.xhtml";
	}

	public String salvar() {
		if(this.ligacoes.getId() == null) {
			LigacaoDAO.getInstance().salvar(ligacoes);
		} else {
			LigacaoDAO.getInstance().alterar(ligacoes);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-ligacao.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public Ligacoes getLigacoes() {
		return ligacoes;
	}

	public void setLigacoes(Ligacoes ligacoes) {
		this.ligacoes = ligacoes;
	}
	
	


}