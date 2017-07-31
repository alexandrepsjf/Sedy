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
import model.Bairro;
import model.Email;

@Named
@ViewScoped
public class InclusaoEmailController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Email registro;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.registro = EmailDAO.getInstance().getEmail(new Integer(paramId));
		}else{
			this.registro = new Email();
		}
	}

	public String voltar() {
		return "consulta-email.xhtml";
	}

	public String salvar() {
		if(this.registro.getId() == null) {
			EmailDAO.getInstance().salvar(registro);
		} else {
			EmailDAO.getInstance().alterar(registro);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-email.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

        public Email getRegistro() {
            return registro;
        }

        public void setRegistro(Email registro) {
            this.registro = registro;
        }

	
	

}