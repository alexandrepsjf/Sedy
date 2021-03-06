/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NivelDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Nivel;

/**
 *
 * @author Alexandre
 */
public class ManterNivelController extends HttpServlet {

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
            RequestDispatcher view = request.getRequestDispatcher("/manterNivel.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            int checkNivel, cliente, pedido, ligacaoRecebida, configuracao, usuario, relatorio, forma_pgm, produto;
            if (request.getParameter("nivel") == null) {
                checkNivel = 0;
            } else {
                checkNivel = 1;
            }
            if (request.getParameter("cliente") == null) {
                cliente = 0;
            } else {
                cliente = 1;
            }
            if (request.getParameter("pedido") == null) {
                pedido = 0;
            } else {
                pedido = 1;
            }
            if (request.getParameter("ligacaoRecebida") == null) {
                ligacaoRecebida = 0;
            } else {
                ligacaoRecebida = 1;
            }
            if (request.getParameter("configuracao") == null) {
                configuracao = 0;
            } else {
                configuracao = 1;
            }
            if (request.getParameter("usuario") == null) {
                usuario = 0;
            } else {
                usuario = 1;
            }
            if (request.getParameter("relatorio") == null) {
                relatorio = 0;
            } else {
                relatorio = 1;
            }
            if (request.getParameter("formaPagamento") == null) {
                forma_pgm = 0;
            } else {
                forma_pgm = 1;
            }
            if (request.getParameter("produto") == null) {
                produto = 0;
            } else {
                produto = 1;
            }
            Nivel nivel = new Nivel(id, nome, configuracao, usuario, checkNivel, produto, relatorio, forma_pgm, ligacaoRecebida, pedido, cliente);
            NivelDAO.getInstance().salvar(nivel);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaNivelController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");
            Integer id = Integer.parseInt(request.getParameter("id"));
            Nivel nivel = NivelDAO.getInstance().getNivel(id);
            request.setAttribute("nivel", nivel);
            RequestDispatcher view = request.getRequestDispatcher("/manterNivel.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
             String test = request.getParameter("nivel");
            int checkNivel, cliente, pedido, ligacaoRecebida, configuracao, usuario, relatorio, forma_pgm, produto;
            if (request.getParameter("nivel") == null) {
                checkNivel = 0;
            } else {
                checkNivel = 1;
            }
            if (request.getParameter("cliente") == null) {
                cliente = 0;
            } else {
                cliente = 1;
            }
            if (request.getParameter("pedido") == null) {
                pedido = 0;
            } else {
                pedido = 1;
            }
            if (request.getParameter("ligacaoRecebida") == null) {
                ligacaoRecebida = 0;
            } else {
                ligacaoRecebida = 1;
            }
            if (request.getParameter("configuracao") == null) {
                configuracao = 0;
            } else {
                configuracao = 1;
            }
            if (request.getParameter("usuario") == null) {
                usuario = 0;
            } else {
                usuario = 1;
            }
            if (request.getParameter("relatorio") == null) {
                relatorio = 0;
            } else {
                relatorio = 1;
            }
            if (request.getParameter("formaPagamento") == null) {
                forma_pgm = 0;
            } else {
                forma_pgm = 1;
            }
            if (request.getParameter("produto") == null) {
                produto = 0;
            } else {
                produto = 1;
            }
            Nivel nivel = new Nivel(id, nome, configuracao, usuario, checkNivel, produto, relatorio, forma_pgm, ligacaoRecebida, pedido, cliente);
            NivelDAO.getInstance().alterar(nivel);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaNivelController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Excluir");

            Integer id = Integer.parseInt(request.getParameter("id"));
            Nivel nivel = NivelDAO.getInstance().getNivel(id);
            request.setAttribute("nivel", nivel);
            RequestDispatcher view = request.getRequestDispatcher("/manterNivel.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            int checkNivel, cliente, pedido, ligacaoRecebida, configuracao, usuario, relatorio, forma_pgm, produto;
           
            if (request.getParameter("nivel") == null) {
                checkNivel = 1;
            } else {
                checkNivel = 0;
            }
            if (request.getParameter("cliente") == null) {
                cliente = 0;
            } else {
                cliente = 1;
            }
            if (request.getParameter("pedido") == null) {
                pedido = 0;
            } else {
                pedido = 1;
            }
            if (request.getParameter("ligacaoRecebida") == null) {
                ligacaoRecebida = 0;
            } else {
                ligacaoRecebida = 1;
            }
            if (request.getParameter("configuracao") == null) {
                configuracao = 0;
            } else {
                configuracao = 1;
            }
            if (request.getParameter("usuario") == null) {
                usuario = 0;
            } else {
                usuario = 1;
            }
            if (request.getParameter("relatorio") == null) {
                relatorio = 0;
            } else {
                relatorio = 1;
            }
            if (request.getParameter("formaPagamento") == null) {
                forma_pgm = 0;
            } else {
                forma_pgm = 1;
            }
            if (request.getParameter("produto") == null) {
                produto = 0;
            } else {
                produto = 1;
            }
            Nivel nivel = new Nivel(id, nome, configuracao, usuario, checkNivel, produto, relatorio, forma_pgm, ligacaoRecebida, pedido, cliente);
            NivelDAO.getInstance().excluir(nivel);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaNivelController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

//    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String nome = request.getParameter("nome");
//        int checkNivel, cliente, pedido, ligacaoRecebida, configuracao, usuario, relatorio, formaPagamento, produto;
//        if (request.getParameter("nivel") == null) {
//            checkNivel = 0;
//        } else {
//            checkNivel = 1;
//        }
//        if (request.getParameter("cliente") == null) {
//            cliente = 0;
//        } else {
//            cliente = 1;
//        }
//        if (request.getParameter("pedido") == null) {
//            pedido = 0;
//        } else {
//            pedido = 1;
//        }
//        if (request.getParameter("ligacaoRecebida") == null) {
//            ligacaoRecebida = 0;
//        } else {
//            ligacaoRecebida = 1;
//        }
//        if (request.getParameter("configuracao") == null) {
//            configuracao = 0;
//        } else {
//            configuracao = 1;
//        }
//        if (request.getParameter("usuario") == null) {
//            usuario = 0;
//        } else {
//            usuario = 1;
//        }
//        if (request.getParameter("relatorio") == null) {
//            relatorio = 0;
//        } else {
//            relatorio = 1;
//        }
//        if (request.getParameter("formaPagamento") == null) {
//            formaPagamento = 0;
//        } else {
//            formaPagamento = 1;
//        }
//        if (request.getParameter("produto") == null) {
//            produto = 0;
//        } else {
//            produto = 1;
//        }
//        try {
//            Nivel nivel = new Nivel(id, nome, configuracao, usuario, checkNivel, produto, relatorio, formaPagamento, ligacaoRecebida, pedido, cliente);
//            nivel.gravar();
//            RequestDispatcher view = request.getRequestDispatcher("PesquisaNivelController");
//            view.forward(request, response);
//        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {
//
//        }
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
            Logger.getLogger(ManterNivelController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterNivelController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterNivelController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterNivelController.class.getName()).log(Level.SEVERE, null, ex);
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

//    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String nome = request.getParameter("nome");
//        int checkNivel, cliente, pedido, ligacaoRecebida, configuracao, usuario, relatorio, formaPagamento, produto;
//        if (request.getParameter("nivel") == null) {
//            checkNivel = 0;
//        } else {
//            checkNivel = 1;
//        }
//        if (request.getParameter("cliente") == null) {
//            cliente = 0;
//        } else {
//            cliente = 1;
//        }
//        if (request.getParameter("pedido") == null) {
//            pedido = 0;
//        } else {
//            pedido = 1;
//        }
//        if (request.getParameter("ligacaoRecebida") == null) {
//            ligacaoRecebida = 0;
//        } else {
//            ligacaoRecebida = 1;
//        }
//        if (request.getParameter("configuracao") == null) {
//            configuracao = 0;
//        } else {
//            configuracao = 1;
//        }
//        if (request.getParameter("usuario") == null) {
//            usuario = 0;
//        } else {
//            usuario = 1;
//        }
//        if (request.getParameter("relatorio") == null) {
//            relatorio = 0;
//        } else {
//            relatorio = 1;
//        }
//        if (request.getParameter("formaPagamento") == null) {
//            formaPagamento = 0;
//        } else {
//            formaPagamento = 1;
//        }
//        if (request.getParameter("produto") == null) {
//            produto = 0;
//        } else {
//            produto = 1;
//        }
//        try {
//            Nivel nivel = new Nivel(id, nome, configuracao, usuario, checkNivel, produto, relatorio, formaPagamento, ligacaoRecebida, pedido, cliente);
//            nivel.alterar();
//            RequestDispatcher view = request.getRequestDispatcher("PesquisaNivelController");
//            view.forward(request, response);
//        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {
//
//        }
//
//    }
//public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            request.setAttribute("operacao", "Excluir");
//            int id = Integer.parseInt(request.getParameter("id"));
//            Nivel nivel = Nivel.obterNivel(id);
//            request.setAttribute("nivel", nivel);
//            RequestDispatcher view = request.getRequestDispatcher("/manterNivel.jsp");
//            view.forward(request, response);
//        } catch (ServletException | IOException | ClassNotFoundException ex) {
//        }
//    }
//    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String nome = request.getParameter("nome");
//        int checkNivel, cliente, pedido, ligacaoRecebida, configuracao, usuario, relatorio, formaPagamento, produto;
//        if (request.getParameter("nivel") == null) {
//            checkNivel = 0;
//        } else {
//            checkNivel = 1;
//        }
//        if (request.getParameter("cliente") == null) {
//            cliente = 0;
//        } else {
//            cliente = 1;
//        }
//        if (request.getParameter("pedido") == null) {
//            pedido = 0;
//        } else {
//            pedido = 1;
//        }
//        if (request.getParameter("ligacaoRecebida") == null) {
//            ligacaoRecebida = 0;
//        } else {
//            ligacaoRecebida = 1;
//        }
//        if (request.getParameter("configuracao") == null) {
//            configuracao = 0;
//        } else {
//            configuracao = 1;
//        }
//        if (request.getParameter("usuario") == null) {
//            usuario = 0;
//        } else {
//            usuario = 1;
//        }
//        if (request.getParameter("relatorio") == null) {
//            relatorio = 0;
//        } else {
//            relatorio = 1;
//        }
//        if (request.getParameter("formaPagamento") == null) {
//            formaPagamento = 0;
//        } else {
//            formaPagamento = 1;
//        }
//        if (request.getParameter("produto") == null) {
//            produto = 0;
//        } else {
//            produto = 1;
//        }
//        try {
//            Nivel nivel = new Nivel(id, nome, checkNivel, cliente, pedido, ligacaoRecebida,configuracao,usuario,relatorio,formaPagamento,produto);
//            nivel.excluir();
//            RequestDispatcher view = request.getRequestDispatcher("PesquisaNivelController");
//            view.forward(request, response);
//        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {
//
//        }
//
//    }
}
