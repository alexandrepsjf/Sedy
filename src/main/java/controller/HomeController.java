package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.BairroDAO;
import model.Bairro;

@Named
@ViewScoped
public class HomeController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Bairro bairro;
    
    @PostConstruct
    public void init() {
        System.out.println("oi");
    }
    
    public void testar() {
    	BairroDAO.getInstance().getAllBairros();
    }

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
    

}
