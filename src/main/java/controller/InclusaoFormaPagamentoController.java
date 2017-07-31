package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.BairroDAO;
import dao.EmailDAO;
import dao.FormaPagamentoDAO;
import model.Bairro;
import model.Email;
import model.FormaPgm;

@Named
@ViewScoped
public class InclusaoFormaPagamentoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private FormaPgm registro;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.registro = FormaPagamentoDAO.getInstance().getFormaPagamento(new Integer(paramId));
		}else{
			this.registro = new FormaPgm();
		}
	}

	public String voltar() {
		return "consulta-formaPagamento.xhtml";
	}

	public String salvar() {
		if(this.registro.getId() == null) {
			FormaPagamentoDAO.getInstance().salvar(registro);
		} else {
			FormaPagamentoDAO.getInstance().alterar(registro);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-formaPagamento.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

    public FormaPgm getRegistro() {
        return registro;
    }

    public void setRegistro(FormaPgm registro) {
        this.registro = registro;
    }


	
	

}