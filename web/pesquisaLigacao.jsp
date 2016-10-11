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
        <title>Ligacao</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Ligacao</h1></div>
        <table border="1">            
            <tr> 
                <th>Cod</th>
                <th>Ligacao</th>
                <th colspan="2">Ação</th>                
            </tr>
            <c:forEach items="${ligacao}" var="ligacao">
                <tr>
                    <td ><c:out value="${ligacao.id}" /> </td>
                    <td ><c:out value="${ligacao.forma}" /> </td>
                    <td ><a href="ManterLigacaoController?acao=preparaEditar&id=<c:out value="${ligacao.id}"/>">Editar</a></td>
                    <td ><a href="ManterLigacaoController?acao=preparaExcluir&id=<c:out value="${ligacao.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterLigacaoController?acao=prepararIncluir" method="POST">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>