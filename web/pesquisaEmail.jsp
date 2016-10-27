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
        <title>Email</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Pesquisa de Email</h1></div>
        <table border="1">            
            <tr> 
                <th>Cod Email</th>
                <th>Email</th>
                <th colspan="2">Ação</th>                
            </tr>
            <c:forEach items="${email}" var="email">
                <tr>
                    <td ><c:out value="${email.id}" /> </td>
                    <td ><c:out value="${email.email}" /> </td>
                    <td ><a href="ManterEmailController?acao=prepararEditar&id=<c:out value="${email.id}"/>">Editar</a></td>
                    <td ><a href="ManterEmailController?acao=prepararExcluir&id=<c:out value="${email.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterEmailController?acao=prepararIncluir" method="POST">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
