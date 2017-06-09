/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.FormaPagamentoDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
/**
 *
 * @author Mateu
 */
public class ManterPedidoController extends HttpServlet {

    

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
            RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String hora = request.getParameter("hora");
            float total = Float.parseFloat(request.getParameter("total"));
            Integer idCliente = Integer.parseInt(request.getParameter("idCliente")); 
            Integer idFormaPgm = Integer.parseInt(request.getParameter("idFormaPgm")); 
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario")); 

            Pedido pedido = new Pedido(id, hora, total);
            pedido.setClienteId(ClienteDAO.getInstance().getCliente(idCliente));
            pedido.setFormaPgmId(FormaPagamentoDAO.getInstance().getFormaPagamento(idFormaPgm));
            pedido.setUsuarioId(UsuarioDAO.getInstance().getUsuario(idUsuario));

            PedidoDAO.getInstance().salvar(pedido);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            Integer id = Integer.parseInt(request.getParameter("id"));
            Pedido pedido = PedidoDAO.getInstance().getPedido(id);

            request.setAttribute("pedido", pedido);
            request.setAttribute(("clientes"), ClienteDAO.getInstance().getAllCliente());
            request.setAttribute(("formaPagamento"), FormaPagamentoDAO.getInstance().getAllFormaPagamento());
            request.setAttribute(("usuarios"), UsuarioDAO.getInstance().getAllUsuarios());
            
            RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String hora = request.getParameter("hora");
            float total = Float.parseFloat(request.getParameter("total"));
            Integer idCliente = Integer.parseInt(request.getParameter("idCliente")); 
            Integer idFormaPgm = Integer.parseInt(request.getParameter("idFrmPgto")); 
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario")); 

            Pedido pedido = new Pedido(id, hora, total);
            pedido.setClienteId(ClienteDAO.getInstance().getCliente(idCliente));
            pedido.setFormaPgmId(FormaPagamentoDAO.getInstance().getFormaPagamento(idFormaPgm));
            pedido.setUsuarioId(UsuarioDAO.getInstance().getUsuario(idUsuario));
            PedidoDAO.getInstance().alterar(pedido);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Excluir");

            Integer id = Integer.parseInt(request.getParameter("id"));
            Pedido pedido = PedidoDAO.getInstance().getPedido(id);

            request.setAttribute("pedido", pedido);

            RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String hora = request.getParameter("hora");
            float total = Float.parseFloat(request.getParameter("total"));
            Integer idCliente = Integer.parseInt(request.getParameter("idCliente")); 
            Integer idFormaPgm = Integer.parseInt(request.getParameter("idFormaPgm")); 
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario")); 
            Pedido pedido = new Pedido(id, hora, total);

            PedidoDAO.getInstance().excluir(pedido);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterBairroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterBairroController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterBairroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterBairroController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
