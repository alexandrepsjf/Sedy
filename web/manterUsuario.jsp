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
        <title>Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Usuario -  ${operacao}</h1></div>
        <form action="ManterBairroController?acao=confirmar${operacao}" method="POST" name="frmManterBairro">
        <table>            
            <tr> 
                <td colspan="2"> Cod. usuario </td><td><input type="text" size="15" name="id" value="${usuario.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
            </tr>
            <tr> 
            <tr> 
                <td colspan="2"> Nivel usuario </td>
                
                <td>
                      <select name="pergunta1" class="usuario">
                            <option value="">Selecione</option>
                            <c:forEach var="nivel" items="${niveis}">
                                <option value="${nivel.id}"> ${nivel.nome} </option>
                             </c:forEach>
                      </select>
            </tr>
            <tr> 
                <td colspan="2"> Nome usuario </td><td><input type="text" size="40" name="nome" value="${usuario.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr> 
                <td colspan="2"> senha usuario </td><td><input type="text" size="40" name="senha" value="${usuario.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            <tr> 
                <td colspan="2"> confirma senha usuario </td><td><input type="text" size="40" name="senha" value="${usuario.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>

        </table>
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
                if (form.txtCodUsuario.value == ""){
                    mensagem = mensagem + "Informe o Código do Usuário\n";
                }                             
                
                if (!campoNumerico(form.txtCodUsuario.value)){
                    mensagem = mensagem + "Código do Usuário deve ser numérico\n";
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
        <h3><button>Cadastrar nivel</button></h3>
        <h3><button>Confirmar</button></h3>
    </body>
</html>
