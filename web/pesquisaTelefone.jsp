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
        <title>Pesquisa telefone</title>
        <meta http-equiv="content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
    <body class="search">
        <div class="title"><h1>Pesquisa de Telefone</h1></div>
        <div class="footer"> 
            &#9668; <a href="ManterInicio"><button>inicio</button></a>    
        </div>
        <div class="logoSearch">            
        </div>
        <table  class="table">             
            <tr> 
                <th>Cod Telefone</th>
                <th>Telefone</th>
                <th colspan="2">Ação</th>                
            </tr>
            <c:forEach items="${telefones}" var="telefone">
                <tr>
                    <td ><c:out value="${telefone.id}" /> </td>
                    <td ><c:out value="${telefone.numero}" /> </td>                   
                    <td ><a href="ManterTelefoneController?acao=prepararEditar&id=<c:out value="${telefone.id}"/>">Editar</a></td>
                    <td ><a href="ManterTelefoneController?acao=prepararExcluir&id=<c:out value="${telefone.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>                
        </table>
        <div class="footer">
            <form action="ManterTelefoneController?acao=prepararIncluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
        <div class="logoSearch">            
        </div>
    </body>
</html>
