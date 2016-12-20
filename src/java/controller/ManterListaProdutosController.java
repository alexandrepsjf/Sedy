/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ListaProdutos;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Alexandre
 */
public class ManterListaProdutosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            List<Produto> produtos = ProdutoDAO.obterProdutos();
            request.setAttribute("produtos", produtos);
            request.setAttribute("operacao", "Incluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterListaProdutos.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));        
        int quant = Integer.parseInt(request.getParameter("qtd"));
        try {
            ListaProdutos listaProdutos = new ListaProdutos(id,idCliente,idUsuario,quant);
            listaProdutos.gravar();
            RequestDispatcher view = request.getRequestDispatcher("ManterPedidoController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Produto> produtos = ProdutoDAO.obterProdutos();
            request.setAttribute("produtos", produtos);
            int id = Integer.parseInt(request.getParameter("id"));
            Pedido pedido = Pedido.obterPedido(id);
            request.setAttribute("operacao", "Editar");
            request.setAttribute("pedido", pedido);
            RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        } catch (SQLException ex) {
            Logger.getLogger(ManterListaProdutosController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ManterListaProdutosController.class.getName()).log(Level.SEVERE, null, ex);
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
