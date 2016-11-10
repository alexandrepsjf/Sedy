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
        <form action="ManterUsuarioController?acao=confirmar${operacao}" method="POST" name="frmManterUsuario">
            <table>            
                <tr> 
                    <td > COD. USUARIO </td><td><input type="text"  name="id" value="${usuario.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr> 
                        <td > NIVEL USUARIO </td>

                        <td>
                            <select name="idNivel" class="usuario">
                                <option value="">Selecione</option>
                            <c:forEach var="nivel" items="${niveis}">
                                <option value="${nivel.id}"> ${nivel.nome} </option>
                            </c:forEach>
                        </select>
                </tr>
                <tr> 
                    <td >NOME USUARIO </td><td><input type="text" name="nome" value="${usuario.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                                    <tr> 
                    <td >LOGIN USUARIO </td><td><input type="text" name="login" value="${usuario.login}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td > SENHA DE USUARIO </td><td><input type="password" name="senha1" value="${usuario.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td > CONFIRME SENHA </td><td><input type="password"  name="senha" value="${usuario.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (form.txtCodUsuario.value == "") {
                    mensagem = mensagem + "Informe o Código do Usuário\n";
                }

                if (!campoNumerico(form.txtCodUsuario.value)) {
                    mensagem = mensagem + "Código do Usuário deve ser numérico\n";
                }

                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }

            }
            //-->
        </SCRIPT>       
    </body>
</html>
