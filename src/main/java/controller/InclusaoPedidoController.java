package controller;

import dao.ClienteDAO;
import dao.FormaPagamentoDAO;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.PedidoDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.Cliente;
import model.FormaPgm;
import model.Pedido;
import model.Usuario;

@Named
@ViewScoped
public class InclusaoPedidoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido registro;
        
        private List<Usuario> usuarios;
                
        private Integer usuarioSelecionado;
        
        private List<Cliente> clientes;
        
        private Integer clienteSelecionado;
        
        private List<FormaPgm> formasPagamento;
        
        private Integer formaPagamentoSelecionada;

	@PostConstruct
	public void init() {
		String paramId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(paramId != null) {
			this.registro = PedidoDAO.getInstance().getPedido(new Integer(paramId));
                        this.usuarioSelecionado = this.registro.getUsuarioId().getId();
                        this.clienteSelecionado = this.registro.getClienteId().getId();
                        this.formaPagamentoSelecionada = this.registro.getFormaPgmId().getId();
		}else{
			this.registro = new Pedido();
		}
                this.usuarios = UsuarioDAO.getInstance().getAllUsuarios();
                this.clientes = ClienteDAO.getInstance().getAllCliente();
                this.formasPagamento = FormaPagamentoDAO.getInstance().getAllFormaPagamento();
	}

	public String voltar() {
		return "consulta-pedido.xhtml";
	}

	public String salvar() {
            this.registro.setClienteId(ClienteDAO.getInstance().getCliente(this.clienteSelecionado));
            this.registro.setUsuarioId(UsuarioDAO.getInstance().getUsuario(this.usuarioSelecionado));
            this.registro.setFormaPgmId(FormaPagamentoDAO.getInstance().getFormaPagamento(this.formaPagamentoSelecionada));
		if(this.registro.getId() == null) {
			PedidoDAO.getInstance().salvar(registro);
		} else {
			PedidoDAO.getInstance().alterar(registro);
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect("consulta-pedido.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

        public Pedido getRegistro() {
            return registro;
        }

        public void setRegistro(Pedido registro) {
            this.registro = registro;
        }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Integer usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Integer getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Integer clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public List<FormaPgm> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<FormaPgm> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public Integer getFormaPagamentoSelecionada() {
        return formaPagamentoSelecionada;
    }

    public void setFormaPagamentoSelecionada(Integer formaPagamentoSelecionada) {
        this.formaPagamentoSelecionada = formaPagamentoSelecionada;
    }

	
	

}