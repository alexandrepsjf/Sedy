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
        <title>Pesquisa de Produtos</title>
        <meta http-equiv="content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
    <body class="search">
        <div class="title"><h1>Pesquisa de Produtos</h1></div>
        <table  class="table">             <tr> 
                <th>Código Produto</th>
                <th>Nome</th>
                <th colspan =2>Ação</th>                                
            </tr>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td ><c:out value="${produto.id}" /> </td>
                    <td ><c:out value="${produto.nome}" /> </td>                   
                    <td ><a href="ManterProdutoController?acao=prepararEditar&id=<c:out value="${produto.id}"/>">Editar</a></td>
                    <td ><a href="ManterProdutoController?acao=prepararExcluir&id=<c:out value="${produto.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <div class="footer">
            <form action="ManterProdutoController?acao=prepararIncluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form></div>
        <div class="logoSearch">            
        </div>
    </body>
</html>
