/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Bairro;

/**
 *
 * @author Sujajeb
 */
public class ManterBairroController extends HttpServlet {

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
        } else {
            {
                if (acao.equals("prepararEditar")) {
                    prepararEditar(request, response);
                } else if (acao.equals("confirmarEditar")) {
                    confirmarEditar(request, response);
                } else if (acao.equals("prepararExcluir")) {
                    prepararExcluir(request, response);
                } else if (acao.equals("confirmarExcluir")) {
                    confirmarExcluir(request, response);
                }
            }

        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterBairros.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        float taxa = Float.parseFloat(request.getParameter("taxa"));
        try {
            Bairro bairro = new Bairro(id, nome, taxa);
            bairro.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaBairroController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        float taxa = Float.parseFloat(request.getParameter("taxa"));
        try {
            Bairro bairro = new Bairro(id, nome, taxa);
            bairro.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaBairroController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            int id = Integer.parseInt(request.getParameter("id"));
            Bairro bairro = Bairro.obterBairro(id);
            request.setAttribute("bairro", bairro);
            RequestDispatcher view = request.getRequestDispatcher("/manterBairros.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        float taxa = Float.parseFloat(request.getParameter("taxa"));
        try {
            Bairro bairro = new Bairro(id, nome, taxa);
            bairro.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaBairroController");
            view.forward(request, response);
        } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {

        }

    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            int id = Integer.parseInt(request.getParameter("id"));
            Bairro bairro = Bairro.obterBairro(id);
            request.setAttribute("bairro", bairro);
            RequestDispatcher view = request.getRequestDispatcher("/manterBairros.jsp");
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
