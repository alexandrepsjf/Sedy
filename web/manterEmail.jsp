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
        <div><h1>Email - ${operacao}</h1></div>
        <form action="ManterEmailController?acao=confirmar${operacao}" method="post" name="frmManterEmail" >
        <table>            
            <tr> 
                <td colspan="2"> Cod. Email </td><td><input type="text" name="id" value="${email.id}" size="15" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
            </tr>
            
            <tr> 
                <td colspan="2">  Email </td><td><input type="text" name="email"value="${email.email}" size="15" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr> 
                <td colspan="2"> senha usuario </td><td><input type="text" name="senha"value="${email.senha}" size="15" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            
            <tr> 
                <td colspan="2"> Autenticação </td><td><input type="text" name="autentica"value="${email.autentica}" size="15" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr> 
                <td colspan="2"> Servidor Saida </td><td><input type="text" name="servidorSaida"value="${email.servidorSaida}" size="15" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr> 
                <td colspan="2"> Servidor Entrada </td><td><input type="text" name="servidorEntrada"value="${email.servidorEntrada}" size="15" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>  
        </table>
                        <h3><button type="submit" >Confirmar</button></h3>          

        </form>
        
    </body>
</html>
