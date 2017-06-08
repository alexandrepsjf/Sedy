/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BairroDAO;
import dao.ClienteDAO;
import dao.TelefoneDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Alexandre
 */
public class ManterClienteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Cliente cliente;

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
            request.setAttribute("telefones", TelefoneDAO.getInstance().getAllTelefones());
            request.setAttribute("bairros", BairroDAO.getInstance().getAllBairros());
            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String cep = request.getParameter("cep");
            String dataCadastro = request.getParameter("dataCadastro");
            String horaCadastro = request.getParameter("horaCadastro");
            String email = request.getParameter("email");
            String referenciaEndereco = request.getParameter("referenciaEndereco");
            Integer idBairro = Integer.parseInt(request.getParameter("idBairro"));
            Cliente cliente = new Cliente(id, nome, rua, numero, cep, dataCadastro,horaCadastro,email,referenciaEndereco);
           cliente.setBairroId(BairroDAO.getInstance().getBairro(idBairro));
            ClienteDAO.getInstance().salvar(cliente);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            Integer id = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = ClienteDAO.getInstance().getCliente(id);

            request.setAttribute("cliente", cliente);
            request.setAttribute(("telefones"), TelefoneDAO.getInstance().getAllTelefones());
            request.setAttribute(("bairros"), BairroDAO.getInstance().getAllBairros());
            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            
             String nome = request.getParameter("nome");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String cep = request.getParameter("cep");
            String dataCadastro = request.getParameter("data_cadastro");
            String horaCadastro = request.getParameter("hora_cadastro");
            String email = request.getParameter("email");
            String referenciaEndereco = request.getParameter("referencia");
            Integer idBairro = Integer.parseInt(request.getParameter("bairrocliente"));
            Integer idTelefone = Integer.parseInt(request.getParameter("telefonesCliente"));

            Cliente cliente = new Cliente(id, nome, rua, numero, cep, dataCadastro,horaCadastro,email,referenciaEndereco);
            cliente.setBairroId(BairroDAO.getInstance().getBairro(idBairro));
            cliente.setTelefone(TelefoneDAO.getInstance().getTelefone(idTelefone));
            ClienteDAO.getInstance().alterar(cliente);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Excluir");

            Integer id = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = ClienteDAO.getInstance().getCliente(id);

            request.setAttribute("cliente", cliente);

            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String cep = request.getParameter("cep");
            String dataCadastro = request.getParameter("dataCadastro");
            String horaCadastro = request.getParameter("horaCadastro");
            String email = request.getParameter("email");
            String referenciaEndereco = request.getParameter("referenciaEndereco");
            Integer idBairro = Integer.parseInt(request.getParameter("idBairro"));
            Integer idTelefone = Integer.parseInt(request.getParameter("idTelefone"));

            Cliente cliente = new Cliente(id, nome, rua, numero, cep, dataCadastro,horaCadastro,email,referenciaEndereco);

            ClienteDAO.getInstance().excluir(cliente);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
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


