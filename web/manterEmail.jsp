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
                    <td > COD. EMAIL </td><td><input type="text" name="id" value="${email.id}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr> 
                        <td >  EMAIL </td><td><input type="text" name="email" value="${email.email}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td > SENHA USUARIO </td><td><input type="text" name="senha" value="${email.senha}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr> 
                        <td > AUTENTICAÇÃO </td><td><input type="text" name="autentica" value="${email.autentica}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td > SERVIDOR SAIDA  </td><td><input type="text" name="servidorSaida" value="${email.servidorSaida}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td > SERVIDOR ENTRADA </td><td><input type="text" name="servidorEntrada" value="${email.servidorEntrada}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>  
            </table>
            <h3><button type="submit" >Confirmar</button></h3>
        </form>
        <SCRIPT language="JavaScript">


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
                if (form.txtCodEmail.value == "") {
                    mensagem = mensagem + "Informe o Código do email\n";
                }

                if (!campoNumerico(form.txtCodEmail.value)) {
                    mensagem = mensagem + "Código do Email deve ser numérico\n";
                }

                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }

            }

        </SCRIPT>            
    </body>
</html>
