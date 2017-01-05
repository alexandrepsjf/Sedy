<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title >Bairros</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">   
    </head>
    <body class="keep">
        <h1>Bairros - ${operacao}</h1>
        <div class="footer">
          &#9668; <a  href="ManterInicio"><button>Voltar</button></a> 
        </div>

        <form action="ManterBairroController?acao=confirmar${operacao}" method="POST" name="frmManterBairros" onsubmit="return validarFormulario(this)">
            <table >            
                <tr> 
                    <td > COD. DO BAIRRO </td><td><input type="text" name="id" value="${bairro.id}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr> 
                    <tr>
                        <td > NOME DO BAIRRO </td><td><input type="text" name="nome" value="${bairro.nome}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td > TAXA DE ENTREGA </td><td><input type="text" name="taxa" value="${bairro.taxa}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
            </table>
            <div class="footer">
                <button  type="submit" >Confirmar</button>
            </div>
        </form>                


        <div class="logoSearch">            
        </div>
        <SCRIPT language="JavaScript">
            <!--         
    function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero === true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) === -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";
                if (form.id.value === "") {
                    mensagem = mensagem + "Informe o Código do Bairro\n";
                }
                if (form.taxa.value === "") {
                    mensagem = mensagem + "Informe o Taxa do Bairro\n";
                }
                if (!campoNumerico(form.id.value)) {
                    mensagem = mensagem + "Código do Bairro deve ser numérico\n";
                }
                if (!campoNumerico(form.taxa.value)) {
                    mensagem = mensagem + "Taxa deve ser numérica\n";
                }
                if (mensagem === "") {
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
