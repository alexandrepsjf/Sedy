/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BairroDAO;
import dao.RelatorioDAO;
import java.sql.SQLException;

/**
 *
 * @author mateu
 */
public class Relatorio {
    public static Relatorio obterRelatorio(int id) throws ClassNotFoundException, SQLException {
        return RelatorioDAO.obterRelatorio(id);
    }

    public static Object obterRelatorios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
