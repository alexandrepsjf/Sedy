package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
public class ConsultaFormaPagamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<FormaPgm> registros = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.registros = FormaPagamentoDAO.getInstance().getAllFormaPagamento();
	}

	public String incluir() {
		return "inclusao-formaPagamento.xhtml";
	}
	
	public void excluir(FormaPgm reg) {
		FormaPagamentoDAO.getInstance().excluir(reg);
		init();
	}

        public List<FormaPgm> getRegistros() {
            return registros;
        }

        public void setRegistros(List<FormaPgm> registros) {
            this.registros = registros;
        }
	
}