package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.BairroDAO;
import dao.EmailDAO;
import dao.UsuarioDAO;
import model.Bairro;
import model.Email;
import model.Usuario;

@Named
@ViewScoped
public class ConsultaUsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Usuario> registros = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.registros = UsuarioDAO.getInstance().getAllUsuarios();
	}

	public String incluir() {
		return "inclusao-usuario.xhtml";
	}
	
	public void excluir(Usuario reg) {
		UsuarioDAO.getInstance().excluir(reg);
		init();
	}

        public List<Usuario> getRegistros() {
            return registros;
        }

        public void setRegistros(List<Usuario> registros) {
            this.registros = registros;
        }
	
}