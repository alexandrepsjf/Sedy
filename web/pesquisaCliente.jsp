<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    
    <head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
         <%@page contentType="text/html" pageEncoding="utf-8"%> 
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Cliente</h1></div>
        <table border="1"> 
            <tr> 
                <th>Cod Cliente</th>
                <th>Nome Cliente</th>
                <th colspan =2>Ação</th>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
            <tr> 
                <td><c:out value="${cliente.id}"/></td>
                <td><c:out value="${cliente.nome}"/></td>
                <td><a href="ManterClienteController?acao=prepararEditar&id=<c:out value="${cliente.id}"/>">Editar</a></td>
                <td><a href="ManterClienteController?acao=prepararExcluir&id=<c:out value="${cliente.id}"/>">Excluir</a></td>
                
            </tr>
            </c:forEach>        
        </table>
        <form action="ManterClienteController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
