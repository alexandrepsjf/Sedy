/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
            /* }else{
                if(acao.equals("prepararEditar")){
                    prepararIncluir(request, response);
                }else{
                    if(acao.equals("confirmarEditar")){
                        prepararIncluir(request, response);
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
            }*/

        }

    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterNivel.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        System.out.println(request.getParameter("pedido"));
        boolean pedido = Boolean.parseBoolean(request.getParameter("pedido"));
          boolean cliente = Boolean.parseBoolean(request.getParameter("cliente"));
        boolean ligacaoRecebida = Boolean.parseBoolean(request.getParameter("ligacaoRecebida"));
        boolean configuracao = Boolean.parseBoolean(request.getParameter("configuracao"));
        boolean checkNivel = Boolean.parseBoolean(request.getParameter("nivel"));
          System.out.println(checkNivel);
          System.out.println(request.getParameterValues("nivel"));
        boolean usuario = Boolean.parseBoolean(request.getParameter("usuario"));
        boolean relatorio = Boolean.parseBoolean(request.getParameter("relatorio"));
        boolean formaPagamento = Boolean.parseBoolean(request.getParameter("formaPagamento"));
        boolean produto = Boolean.parseBoolean(request.getParameter("produto"));
        try {
            Nivel nivel = new Nivel(id, nome, configuracao, usuario, checkNivel, produto, relatorio, formaPagamento, ligacaoRecebida, pedido, cliente);
            nivel.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaNivelController");
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
