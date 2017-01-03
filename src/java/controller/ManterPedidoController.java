/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.FormaPagamentoDAO;
import dao.ListaProdutosDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
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
import model.Cliente;
import model.FormaPagamento;
import model.ListaProdutos;
import model.Pedido;
import model.Produto;
import model.Usuario;

/**
 *
 * @author Alexandre
 */
public class ManterPedidoController extends HttpServlet {

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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Produto> produtos = ProdutoDAO.obterProdutos();
            List<FormaPagamento> formaPagamentos = FormaPagamentoDAO.obterFormasPagamento();
            List<Usuario> usuarios = UsuarioDAO.obterUsuarios();
            List<Cliente> clientes = ClienteDAO.obterClientes();
            request.setAttribute("clientes", clientes);
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("produtos", produtos);
            request.setAttribute("formaPagamentos", formaPagamentos);
            request.setAttribute("operacao", "Incluir");
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

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String data_2 = request.getParameter("data_2");
        String hora = request.getParameter("hora");
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        int idFrmPgto = Integer.parseInt(request.getParameter("idFrmPgto"));
        float total = Float.parseFloat(request.getParameter("total"));
        try {
            Pedido pedido = new Pedido(id, hora, data_2, total, null, idCliente, null, idUsuario, null, idFrmPgto);
            pedido.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Produto> produtos = ProdutoDAO.obterProdutos();
            List<FormaPagamento> formaPagamentos = FormaPagamentoDAO.obterFormasPagamento();
            List<Usuario> usuarios = UsuarioDAO.obterUsuarios();
            List<Cliente> clientes = ClienteDAO.obterClientes();
            Pedido pedido = Pedido.obterPedido(id);
            request.setAttribute("clientes", clientes);
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("produtos", produtos);
            request.setAttribute("formaPagamentos", formaPagamentos);
            request.setAttribute("operacao", "Editar");
            request.setAttribute("pedido", pedido);
            RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException ex) {
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String data_2 = request.getParameter("data_2");
        String hora = request.getParameter("hora"); 
        
        int idFrmPgto = Integer.parseInt(request.getParameter("idFrmPgto"));
        float total = Float.parseFloat(request.getParameter("total"));
        try {
            Pedido pedido = new Pedido(id, hora, data_2, total, null, 0, null, 0, null, idFrmPgto);
            pedido.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Produto> produtos = ProdutoDAO.obterProdutos();
            List<FormaPagamento> formaPagamentos = FormaPagamentoDAO.obterFormasPagamento();
            List<Usuario> usuarios = UsuarioDAO.obterUsuarios();
            List<Cliente> clientes = ClienteDAO.obterClientes();
            Pedido pedido = Pedido.obterPedido(id);
            request.setAttribute("clientes", clientes);
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("produtos", produtos);
            request.setAttribute("formaPagamentos", formaPagamentos);
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("pedido", pedido);
            RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
            view.forward(request, response);

        } catch (ServletException | IOException ex) {
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String data_2 = request.getParameter("data_2");
        String hora = request.getParameter("hora");         
        int idFrmPgto = Integer.parseInt(request.getParameter("idFrmPgto"));
        float total = Float.parseFloat(request.getParameter("total"));
        try {
            Pedido pedido = new Pedido(id, hora, data_2, total, null, 0, null, 0, null, idFrmPgto);
            pedido.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

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
