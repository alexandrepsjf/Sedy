<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Nivel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Nivel</h1></div>
        <table>            
            <tr> 
                <td colspan="2"> Nome  nivel <input type="text" size="40"  name="nome" value="${nivel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr><td>NIVEL<input  type="radio"  name="id" value="${nivel.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td><td>RELATORIO <input  type="radio" name="relatorio" value="${nivel.relatorio}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td>LIGACAO RECEBIDA<input checked="true"  disabled="true" type="radio" name="ligacaoRecebida" value="${nivel.ligacaoRecebida}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
            <tr> <td>CONFIGURACAO<input  type="radio" name="configuracao" value="${nivel.configuracao}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td>USUARIO <input  type="radio" name="usuario" value="${nivel.usuario}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td>PEDIDO<input checked="true"  disabled="true" type="radio" name="pedido" value="${nivel.pedido}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
            <tr><td>PRODUTOS<input  type="radio" name="produto" value="${nivel.produto}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td>FORMAS DE PAGTO <input  type="radio" name="formaPagamento" vallue="${nivel.formaPagamento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td>CLIENTES<input checked="true"  disabled="true" type="radio" name="cliente" value="${nivel.cliente}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
        </table>

        <h3><button>Confirmar</button></h3>
    </body>
</html>
