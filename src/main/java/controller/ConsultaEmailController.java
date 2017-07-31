package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.BairroDAO;
import dao.EmailDAO;
import model.Bairro;
import model.Email;

@Named
@ViewScoped
public class ConsultaEmailController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Email> registros = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.registros = EmailDAO.getInstance().getAllEmails();
	}

	public String incluir() {
		return "inclusao-email.xhtml";
	}
	
	public void excluir(Email reg) {
		EmailDAO.getInstance().excluir(reg);
		init();
	}

        public List<Email> getRegistros() {
            return registros;
        }

        public void setRegistros(List<Email> registros) {
            this.registros = registros;
        }
	
}