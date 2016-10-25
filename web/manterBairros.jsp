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
        <title>Bairros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Bairros - ${operacao}</h1></div>
               <form action="ManterBairroController?acao=confirmar${operacao}" method="POST" name="frmManterBairro" >
        <table>            
            <tr> 
                <td colspan="2"> Cod. Bairro </td><td><input type="text" name="id" value="${bairro.id}" size="15" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
            </tr> 
            <tr>
            <td colspan="2"> Nome Bairro </td><td><input type="text" name="nome" value="${bairro.nome}" size="40" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
        </tr>
        <tr>
            <td colspan="2"> Taxa entrega do Bairro </td><td><input type="text" name="taxa" value="${bairro.taxa}" size="15" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
        </tr>
    </table>
        <h3><button type="submit" >Confirmar</button></h3>
               </form>
</body>
</html>
