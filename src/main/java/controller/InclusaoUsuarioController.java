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
import dao.NivelDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.Bairro;
import model.Email;
import model.Nivel;
import model.Usuario;

@Named
@ViewScoped
public class InclusaoUsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario registro;
        
        private List<Nivel> niveisUsuario;
        
        private Integer nivelSelecionado;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.registro = UsuarioDAO.getInstance().getUsuario(new Integer(paramId));
                        this.nivelSelecionado = this.registro.getNivelId().getId();
		}else{
			this.registro = new Usuario();
		}
                this.niveisUsuario = NivelDAO.getInstance().getAllNivel();
	}

	public String voltar() {
		return "consulta-usuario.xhtml";
	}

	public String salvar() {
                this.registro.setNivelId(NivelDAO.getInstance().getNivel(this.nivelSelecionado));
		if(this.registro.getId() == null) {
			UsuarioDAO.getInstance().salvar(registro);
		} else {
			UsuarioDAO.getInstance().alterar(registro);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-usuario.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

        public Usuario getRegistro() {
            return registro;
        }

        public void setRegistro(Usuario registro) {
            this.registro = registro;
        }

    public List<Nivel> getNiveisUsuario() {
        return niveisUsuario;
    }

    public void setNiveisUsuario(List<Nivel> niveisUsuario) {
        this.niveisUsuario = niveisUsuario;
    }

    public Integer getNivelSelecionado() {
        return nivelSelecionado;
    }

    public void setNivelSelecionado(Integer nivelSelecionado) {
        this.nivelSelecionado = nivelSelecionado;
    }

}