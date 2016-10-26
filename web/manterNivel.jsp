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
        <title>Nivel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Nivel</h1></div>
        <form action="ManterNivelController?acao=confirmar${operacao}" method="post" name="frmManterNivel" >
            <table>            
                <tr>
                    <td colspan="2"> Cod.  nivel <input type="text" size="10"  name="id" value="${nivel.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2"> Nome  nivel <input type="text" size="40"  name="nome" value="${nivel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><input  type="checkbox"  name="nivel" value="${nivel.nivel}"<c:if test="${operacao != 'Incluir'}"> disabled</c:if>>NIVEL</td>
                    <td> <input  type="checkbox" name="relatorio" value="${nivel.relatorio}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>RELATORIO</td>
                    <td><input checked   type="checkbox" name="ligacaoRecebida" value="${nivel.ligacaoRecebida}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>LIGACAO RECEBIDA</td>
                </tr>
                <tr> 
                    <td><input  type="checkbox" name="configuracao" value="${nivel.configuracao}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>CONFIGURACAO</td>
                    <td> <input  type="checkbox" name="usuario" value="${nivel.usuario}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>USUARIO</td>
                    <td><input checked   type="checkbox" name="pedido" value="${nivel.pedido}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>PEDIDO</td>
                </tr>
                <tr><td><input  type="checkbox" name="produto" value="${nivel.produto}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>PRODUTOS</td>
                    <td> <input  type="checkbox" name="formaPagamento" value="${nivel.formaPagamento}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>FORMAS DE PAGTO</td>
                    <td><input checked   type="checkbox" name="cliente" value="${nivel.cliente}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>CLIENTES</td>
                </tr>
            </table>
            <h3><button type="submit">Confirmar</button></h3>
        </form>
    <SCRIPT language="JavaScript">
            <!--
            
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) == -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtCodNivel.value == "${nivel.id}"){
                    mensagem = mensagem + "Informe o Código do Nivel\n";
                }                             
                
                if (!campoNumerico(form.txtCodNivel.value)){
                    mensagem = mensagem + "Código do Nivel deve ser numérico\n";
                }
                                                
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
                
           }
            //-->
        </SCRIPT>            
    </body>
</html>
