

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <head>
        <title>Usuario</title>
        <meta http-equiv="content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">

    </head>
    <body class="search">
        <div class="title"><h1>Usuario</h1></div>
        <table  class="table">             <tr> 
                <th>Cod Usuário</th>
                <th>Nome Usuário </th>
                <th colspan =2>Ação</th>
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
                <tr> 
                    <td><c:out value="${usuario.id}"/></td>
                    <td><c:out value="${usuario.nome}"/></td>
                    <td><a href="ManterUsuarioController?acao=prepararEditar&id=<c:out value="${usuario.id}"/>">Editar</a></td>
                    <td><a href="ManterUsuarioController?acao=prepararExcluir&id=<c:out value="${usuario.id}"/>">Excluir</a></td>

                </tr>
            </c:forEach>        
        </table>
        <div class="footer">
            <form action="ManterUsuarioController?acao=prepararIncluir" method="POST">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form></div>
        <div class="logoSearch">            
        </div>
    </body>
</html>
