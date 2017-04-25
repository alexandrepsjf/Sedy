<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@page contentType="text/html" pageEncoding="utf-8"%>  
<html>
    <head>
        <title>Pesquisa de Relatorios</title>
        <meta http-equiv="content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">   
    </head>
    <body class="search">

        <div class="title"><h1>Pesquisa de Relatórios</h1></div>
        <div class="footer"> 
            &#9668; <a href="ManterInicio"><button>inicio</button></a>    
        </div>       
        <div class="logoSearch">            
        </div>
        <form  action="RelatorioBairroController" method="POST">  
            <table  class="table">            
                <tr> 
                    <th>Tipo do relatorio</th>
                    <th>Parâmetro do relatòrio</th>                             
                </tr>

                <tr>
                    <td>
                        <select name="reportName" >
                            <option>
                                Clientes
                            </option>
                            <option>
                                Pedidos
                            </option>
                            <option>
                                Bairros
                            </option>
                            <option>
                                Produtos
                            </option>
                            <option>
                                Formas de pgto
                            </option>
                            <option>
                                Niveis
                            </option>
                            <option>
                                Usuarios
                            </option>
                            <option>
                                Emails
                            </option>
                            <option>
                                Telefones
                            </option>
                            <option>
                                Ligacoes
                            </option>
                        </select>
                    </td>
                    <td>
                        <select name="reportParameter">
                            <option> 

                            </option>
                            <option>
                                Cliente
                            </option>
                            <option>
                                Cliente
                            </option>
                            <option>
                                Cliente
                            </option>
                        </select>
                    </td>
                </tr>

            </table>         
            <div class="footer">  
                <input  type="submit" name="btnIncluir" value="Gerar">
                </form>

            </div>

    </body>
</html>