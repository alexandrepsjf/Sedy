/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.TelefoneDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Telefone;

/**
 *
 * @author Alexandre
 */
public class ManterTelefoneController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Telefone telefone;

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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("clientes", ClienteDAO.getInstance().getAllCliente());
            RequestDispatcher view = request.getRequestDispatcher("/manterTelefone.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String telefoneCliente = request.getParameter("telefone");
            Telefone telefone = new Telefone(id, telefoneCliente);
            telefone.setCliente(ClienteDAO.getInstance().getCliente(idCliente));
            TelefoneDAO.getInstance().salvar(telefone);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaTelefoneController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");
            Integer id = Integer.parseInt(request.getParameter("id"));
            telefone = TelefoneDAO.getInstance().getTelefone(id);
            request.setAttribute("telefone", telefone);
            request.setAttribute("clientes", ClienteDAO.getInstance().getAllCliente());
            RequestDispatcher view = request.getRequestDispatcher("/manterTelefone.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String telefoneCliente = request.getParameter("telefone");
            Telefone telefone = new Telefone(id, telefoneCliente);
            telefone.setCliente(ClienteDAO.getInstance().getCliente(idCliente));
            TelefoneDAO.getInstance().alterar(telefone);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaTelefoneController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Excluir");
            Integer id = Integer.parseInt(request.getParameter("id"));
            telefone = TelefoneDAO.getInstance().getTelefone(id);
            request.setAttribute("telefone", telefone);
            request.setAttribute("clientes", ClienteDAO.getInstance().getAllCliente());
            RequestDispatcher view = request.getRequestDispatcher("/manterTelefone.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));           
            String telefoneCliente = request.getParameter("telefone");
            Telefone telefone = new Telefone(id, telefoneCliente);           
            TelefoneDAO.getInstance().excluir(telefone);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaTelefoneController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
