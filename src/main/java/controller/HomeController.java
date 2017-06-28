package controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
@ViewScoped
public class HomeController implements Serializable {

    private static final long serialVersionUID = 1L;

    static final Logger log = Logger.getLogger(HomeController.class);

    @PostConstruct
    public void init() {
        System.out.println("oi");
    }

}
