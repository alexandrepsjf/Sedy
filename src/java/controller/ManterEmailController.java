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
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Incluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterEmail.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String senha = request.getParameter("senha");
            String emailParam = request.getParameter("email");
            String autentica = request.getParameter("autentica");
            String servidorSaida = request.getParameter("servidorSaida");
            String servidorEntrada = request.getParameter("servidorEntrada");
            email = new Email(id, emailParam, senha, autentica, servidorSaida, servidorEntrada);
            EmailDAO.getInstance().salvar(email);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEmailController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
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

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            email = EmailDAO.getInstance().getEmail(id);
            request.setAttribute("email", email);
            request.setAttribute("operacao", "Editar");
            RequestDispatcher view = request.getRequestDispatcher("/manterEmail.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String senha = request.getParameter("senha");
            String emailParam = request.getParameter("email");
            String autentica = request.getParameter("autentica");
            String servidorSaida = request.getParameter("servidorSaida");
            String servidorEntrada = request.getParameter("servidorEntrada");
            email = new Email(id, emailParam, senha, autentica, servidorSaida, servidorEntrada);
            EmailDAO.getInstance().alterar(email);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEmailController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            email = EmailDAO.getInstance().getEmail(id);
            request.setAttribute("email", email);
            request.setAttribute("operacao", "Excluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterEmail.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String senha = request.getParameter("senha");
            String emailParam = request.getParameter("email");
            String autentica = request.getParameter("autentica");
            String servidorSaida = request.getParameter("servidorSaida");
            String servidorEntrada = request.getParameter("servidorEntrada");
            email = new Email(id, emailParam, senha, autentica, servidorSaida, servidorEntrada);
            EmailDAO.getInstance().excluir(email);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEmailController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

}
