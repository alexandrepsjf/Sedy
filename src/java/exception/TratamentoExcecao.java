/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class TratamentoExcecao extends HttpServlet {

    

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
        Exception excecao = (Exception)
                request.getAttribute("javax.servelt.error.exception");
        Integer codigoStatus = (Integer)
                request.getAttribute("javax.servelt.error.status_code");
        String nomeServelt = (String)
                request.getAttribute("javax.servelt.error.servelt_name");
        String uriRequisicao = (String)
                request.getAttribute("javax.error.request_uri");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String titulo = "informação de Exceção";
            String  tipoDocto= "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">n";
            /* TODO output your page here. You may use following sample code. */
            out.println(tipoDocto+"<html>\n <head><tittle>"+titulo+"</title></head>\n<body>");
            out.println("<h2>Informação sobre exceção </h2>");
            out.println("Codigo do Status :" +codigoStatus+"</br></br>");
            out.println("Nome do Servelt :" +nomeServelt+"</br></br>");           
            out.println("Tipo de Exceção :" +excecao.getClass().getName()+"</br></br>");
            out.println("URI da requisição :" +uriRequisicao+"</br></br>");
            out.println("Mensagem :" +excecao.getMessage()+"</br></br>");
            out.println("</body>");
            out.println("</html>");
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
