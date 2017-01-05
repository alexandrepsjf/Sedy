
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
        <title>Formas pgto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
    <body class="keep">
        <div><h1>Forma de pagamento - ${operacao}</h1></div>
        <form action="ManterFormaPagamentoController?acao=confirmar${operacao}" method="POST" name="frmManterFormaPagamento" onsubmit="return validarFormulario(this)">
            <table>            
                <tr> 
                    <td> COD. FORMA DE PGTO </td><td><input name="id" type="text"  value="${formasPagamento.id}"<c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td > NOME DA FORMA DE PGTO </td> <td><input name="forma" type="text"  value="${formasPagamento.forma}"<c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                </tr>
            </table>
            <div class="footer">
                <button  type="submit" >Confirmar</button>
            </div>
        </form>
        <div class="logoSearch">            
        </div>        </form>
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
            if (form.id.value == "") {
                mensagem = mensagem + "Informe o Código da Forma de Pagamento\n";
            }

            if (!campoNumerico(form.id.value)) {
                mensagem = mensagem + "Código da Forma de Pagamento deve ser numérica\n";
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
