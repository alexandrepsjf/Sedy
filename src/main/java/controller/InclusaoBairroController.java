package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.BairroDAO;
import model.Bairro;

@Named
@ViewScoped
public class InclusaoBairroController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Bairro bairro;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.bairro = BairroDAO.getInstance().getBairro(new Integer(paramId));
		}else{
			this.bairro = new Bairro();
		}
	}

	public String voltar() {
		return "consulta-bairro.xhtml";
	}

	public String salvar() {
		if(this.bairro.getId() == null) {
			BairroDAO.getInstance().salvar(bairro);
		} else {
			BairroDAO.getInstance().alterar(bairro);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-bairro.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	

}