

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
        <meta charset="UTF-8">

    </head>
    <body>
        <div><h1>Usuario</h1></div>
        <table border="1"> 
            <tr> 
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
        <form action="ManterUsuarioController?acao=prepararIncluir" method="POST">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
