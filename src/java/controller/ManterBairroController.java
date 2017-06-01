package controller;

import dao.BairroDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bairro;

public class ManterBairroController extends HttpServlet {
    
    private Bairro bairro;
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
                bairro = BairroDAO.getInstance().getBairro(id);
                request.setAttribute("bairro", bairro);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterBairro.jsp");
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
            String nome = request.getParameter("nome");
            float taxa = Float.parseFloat(request.getParameter("taxa"));
            if (operacao.equals("incluir")) {
                bairro = new Bairro(nome, taxa);
                BairroDAO.getInstance().salvar(bairro);
            } else if (operacao.equals("editar")) {
                bairro.setNome(nome);
                bairro.setTaxa(taxa);
                BairroDAO.getInstance().salvar(bairro);
            } else if (operacao.equals("excluir")) {
                BairroDAO.getInstance().excluir(bairro);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarBairroController");
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
