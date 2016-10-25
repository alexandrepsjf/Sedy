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
        <title>Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>       

        <div><h1>Produto - ${operacao}</h1></div>
        <form action="ManterProdutoController?acao=confirmar${operacao}" method="POST" name="frmManterProduto" >
            <table>            
                <tr> 
                    <td colspan="2"> Cod. Produto </td><td><input type="text"  name= "id" value="${produto.id}" size="15"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2"> Nome Produto </td><td><input type="text" name ="nome" value="${produto.nome}" size="40"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2"> Unidade produto </td><td><input type="text" name="unidade" value="${produto.unidade}" size="15"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2"> Preço produto </td><td><input type="text" name="valor" value="${produto.valor}" size="15"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
            </table>        
            <h3><button type="submit">Confirmar</button></h3>
        </form>
    </body>

</html>
