/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NivelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Nivel;
import model.Usuario;

/**
 *
 * @author Alexandre
 */
public class ManterUsuarioController extends HttpServlet {

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
//        } else if (acao.equals("prepararEditar")) {
//            prepararEditar(request, response);
//        } else if (acao.equals("confirmarEditar")) {
//            confirmarEditar(request, response);
//        } else if (acao.equals("prepararExcluir")) {
//            prepararExcluir(request, response);
//        } else if (acao.equals("confirmarExcluir")) {
//            confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Incluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        String usuarioNome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String login = request.getParameter("login");
        int idNivel = Integer.parseInt(request.getParameter("idNivel"));
        
        RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

//
//    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String usuario2 = request.getParameter("nome");
//        String senha = request.getParameter("senha");
//        String login = request.getParameter("login");
//        int idNivel = Integer.parseInt(request.getParameter("idNivel"));
//        try {
//            Usuario usuario = new Usuario(id, usuario2, senha, login, null, idNivel);
//            usuario.alterar();
//            RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
//            view.forward(request, response);
//        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {
//
//        }
//
//    }
//
//    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
//        try {
//            List<Nivel> niveis = NivelDAO.obterNiveis();
//            request.setAttribute("niveis", niveis);
//            request.setAttribute("operacao", "Editar");
//            int id = Integer.parseInt(request.getParameter("id"));
//            Usuario usuario = Usuario.obterUsuario(id);
//            request.setAttribute("usuario", usuario);
//            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
//            view.forward(request, response);
//        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
//        }
//    }
//
//    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String usuario2 = request.getParameter("nome");
//        String senha = request.getParameter("senha");
//        String login = request.getParameter("login");
//        int idNivel = 0;
//        try {
//            Usuario usuario = new Usuario(id, usuario2, senha, login, null, idNivel);
//            usuario.excluir();
//            RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
//            view.forward(request, response);
//        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {
//
//        }
//
//    }
//
//    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            List<Nivel> niveis = NivelDAO.obterNiveis();
//            request.setAttribute("niveis", niveis);
//            request.setAttribute("operacao", "Excluir");
//            int id = Integer.parseInt(request.getParameter("id"));
//            Usuario usuario = Usuario.obterUsuario(id);
//            request.setAttribute("usuario", usuario);
//            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
//            view.forward(request, response);
//        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
