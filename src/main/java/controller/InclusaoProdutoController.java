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
import dao.ProdutoDAO;
import model.Bairro;
import model.Email;
import model.Produto;

@Named
@ViewScoped
public class InclusaoProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto registro;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.registro = ProdutoDAO.getInstance().getProduto(new Integer(paramId));
		}else{
			this.registro = new Produto();
		}
	}

	public String voltar() {
		return "consulta-produto.xhtml";
	}

	public String salvar() {
		if(this.registro.getId() == null) {
			ProdutoDAO.getInstance().salvar(registro);
		} else {
			ProdutoDAO.getInstance().alterar(registro);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-produto.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

        public Produto getRegistro() {
            return registro;
        }

        public void setRegistro(Produto registro) {
            this.registro = registro;
        }

	
	

}