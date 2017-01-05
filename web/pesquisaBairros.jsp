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
        <title>Pesquisa de Bairros</title>
        <meta http-equiv="content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">   
    </head>
    <body class="search">
        <div class="title"><h1>Pesquisa de Bairros</h1></div>
        <table  class="table">            
            <tr> 
                <th>Código Bairro</th>
                <th>Nome Bairro</th>
                <th colspan="2">Ação</th>                
            </tr>
            <c:forEach items="${bairros}" var="bairro">
                <tr>
                    <td ><c:out value="${bairro.id}" /> </td>
                    <td ><c:out value="${bairro.nome}" /> </td>
                    <td ><a href="ManterBairroController?acao=prepararEditar&id=<c:out value="${bairro.id}"/>">Editar</a></td>
                    <td ><a href="ManterBairroController?acao=prepararExcluir&id=<c:out value="${bairro.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table> 
        
        <div class="footer">
        <form  action="ManterBairroController?acao=prepararIncluir" method="POST">
            <input  type="submit" name="btnIncluir" value="Incluir">
        </form>
        </div>
        <div class="logoSearch">            
        </div>
    </body>
</html>
