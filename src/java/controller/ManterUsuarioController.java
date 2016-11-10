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
            throws ServletException, IOException {
       
        
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
            }else{
                if(acao.equals("prepararEditar")){
                    prepararIncluir(request, response);
                }else{
                    if(acao.equals("confirmarEditar")){
                        confirmarEditar(request, response);
                     }else{
                        if(acao.equals("prepararExcluir")){
                            prepararIncluir(request, response);
                        }else{
                            if(acao.equals("confirmarExcluir")){
                                 prepararIncluir(request, response);
                            }
                        }
                    }
                }
            }

        }

    
    

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            List<Nivel> niveis = NivelDAO.obterNiveis();
            
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("niveis", niveis);
            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String usuarioNome = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String login = request.getParameter("login");
        int idNivel = Integer.parseInt(request.getParameter("idNivel"));
       
        try {
            Usuario usuario = new Usuario(id, usuarioNome,login, senha,null,idNivel );
            usuario.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario2 = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String login = request.getParameter("login");
        int idNivel = Integer.parseInt(request.getParameter("idNivel"));
        try {
            Usuario usuario = new Usuario( id, usuario2 ,senha, login ,null, idNivel );
            usuario.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }
     public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            int id = Integer.parseInt (request.getParameter("id"));
            Usuario usuario = Usuario.obterUsuario(id);
            request.setAttribute("usuario",usuario);
            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
        }
    }
    
     public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario2 = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String login = request.getParameter("login");
        int idNivel = Integer.parseInt(request.getParameter("idNivel"));
        try {
            Usuario usuario = new Usuario( id, usuario2 ,senha, login ,null, idNivel );
            usuario.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }
     public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            int id = Integer.parseInt (request.getParameter("id"));
            Usuario usuario = Usuario.obterUsuario(id);
            request.setAttribute("usuario",usuario);
            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
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