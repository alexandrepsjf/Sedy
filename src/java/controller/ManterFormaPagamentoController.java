/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FormaPagamentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FormaPgm;

/**
 *
 * @author Sujajeb
 */
public class ManterFormaPagamentoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
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

            RequestDispatcher view = request.getRequestDispatcher("/manterFormaspgto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String formapgm = request.getParameter("forma");
            

            FormaPgm forma = new FormaPgm(id, formapgm);

            FormaPagamentoDAO.getInstance().salvar(forma);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormaPagamentoController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

        public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            Integer id = Integer.parseInt(request.getParameter("id"));
            FormaPgm formapgm = FormaPagamentoDAO.getInstance().getFormaPagamento(id);

            request.setAttribute("forma", formapgm);

            RequestDispatcher view = request.getRequestDispatcher("/manterFormaspgto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }
            private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String formapgm = request.getParameter("forma");
           

            FormaPgm forma = new FormaPgm(id, formapgm);

            FormaPagamentoDAO.getInstance().alterar(forma);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormaPagamentoController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }
                private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Excluir");

            Integer id = Integer.parseInt(request.getParameter("id"));
            FormaPgm formapgm = FormaPagamentoDAO.getInstance().getFormaPagamento(id);

            request.setAttribute("forma", formapgm);

            RequestDispatcher view = request.getRequestDispatcher("/manterFormaspgto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String forma = request.getParameter("forma");
            

            FormaPgm formapgm = new FormaPgm(id, forma);

            FormaPagamentoDAO.getInstance().excluir(formapgm);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormaPagamentoController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }
}
