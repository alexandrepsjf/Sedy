package controller;

import dao.EmailDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Email;


public class ManterEmailController extends HttpServlet {

    
    private Email email;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }

    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("incluir")) {
                long id = Long.parseLong(request.getParameter("id"));
                email = EmailDAO.getInstance().getEmail(id);
                request.setAttribute("emails", email);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterEmail.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            String emailParam = request.getParameter("email");
            String senha = request.getParameter("senha");
            if (operacao.equals("incluir")) {
                email = new Email(emailParam, senha);
                EmailDAO.getInstance().salvar(email);
            } else if (operacao.equals("editar")) {
                email.setEmail(emailParam);
                email.setSenha(senha);
                EmailDAO.getInstance().salvar(email);
            } else if (operacao.equals("excluir")) {
                EmailDAO.getInstance().excluir(email);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarEmailController");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}