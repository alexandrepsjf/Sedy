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
                    <td > COD. PRODUTO </td><td><input type="text"  name= "id" value="${produto.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td >NOME PRODUTO </td><td><input type="text" name ="nome" value="${produto.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td > UNIDADE DO PRODUTO </td><td><input type="text" name="unidade" value="${produto.unidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td > PREÇO DO PRODUTO </td><td><input type="text" name="valor" value="${produto.valor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (form.txtCodProduto.value == ""){
                    mensagem = mensagem + "Informe o Código do Produto\n";
                }                             
                if (form.txtUnudade.value == ""){
                    mensagem = mensagem + "Informe únidade do Produto\n";
                }
                if (form.txtValor.value == ""){
                    mensagem = mensagem + "Informe o Valor do Produto\n";
                }
                if (!campoNumerico(form.txtProduto.value)){
                    mensagem = mensagem + " O Código do Produto deve ser numérico\n";
                }
                if (!campoNumerico(form.txtUnidade.value)){
                    mensagem = mensagem + "A únidade deve ser numérica\n";
                }
                if (!campoNumerico(form.txtValor.value)){
                    mensagem = mensagem + " O Valor do Produto deve ser numérico\n";
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
