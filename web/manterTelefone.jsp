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
        <title>Telefone</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
    <body class="keep">
        <div><h1>Telefone - ${operacao}</h1></div>
        <div class="footer">
            &#9668; <a  href="ManterInicio"><button>Voltar</button></a> 
        </div>
        <form action="ManterTelefoneController?acao=confirmar${operacao}" method="post" name="frmManterTelefone" onsubmit="return validarFormulario(this)" >
            <table>            
                <tr> 
                    <td > COD. Telefone </td><td><input type="text" name="id" value="${telefone.id}"  <c:if test="${operacao != 'incluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr> 
                        <td >  Telefone </td><td><input type="text" name="numero" value="${telefone.numero}"  <c:if test="${operacao == 'excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CLIENTE</td><td>
                            <select name="idCliente" id="clientes" <c:if test="${operacao != 'incluir'}"> disabled</c:if>>
                                <option value="" >Selecione</option>
                            <c:forEach  items="${clientes}" var="cliente">
                                <option value="${cliente.id}" <c:if test="${telefone.idCliente == cliente.id}"> selected</c:if> >  ${cliente.nome} </option>
                            </c:forEach>
                        </select>
                </tr>  
            </table>
            <div class="footer">
                <button  type="submit" >Confirmar</button>
            </div>
        </form>
        <div class="logoSearch">            
        </div>        </form>
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
            if (form.id.value == "") {
                mensagem = mensagem + "Informe o Código do email\n";
            }

            if (!campoNumerico(form.id.value)) {
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
