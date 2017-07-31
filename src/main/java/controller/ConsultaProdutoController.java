package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
public class ConsultaProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Produto> registros = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.registros = ProdutoDAO.getInstance().getAllProdutos();
	}

	public String incluir() {
		return "inclusao-produto.xhtml";
	}
	
	public void excluir(Produto reg) {
		ProdutoDAO.getInstance().excluir(reg);
		init();
	}

        public List<Produto> getRegistros() {
            return registros;
        }

        public void setRegistros(List<Produto> registros) {
            this.registros = registros;
        }
	
}