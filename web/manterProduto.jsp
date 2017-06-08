
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
    <head class="keep">
        <title>Produto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
<body>       

    <div><h1>Produto - ${operacao}</h1></div>
    <div class="footer">
          &#9668; <a  href="ManterInicio"><button>Voltar</button></a> 
        </div>
    <form action="ManterProdutoController?acao=confirmar${operacao}" method="POST" name="frmManterProduto" onsubmit="return validarFormulario(this)" >
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
            mensagem = mensagem + "Informe o Código do Produto\n";
        }
        if (form.unidade.value == "") {
            mensagem = mensagem + "Informe AS UNIDADES do Produto\n";
        }
        if (form.valor.value == "") {
            mensagem = mensagem + "Informe o PREÇO do Produto\n";
        }

        if (!campoNumerico(form.id.value)) {
            mensagem = mensagem + " O Código do Produto deve ser numérico\n";
        }
        if (!campoNumerico(form.unidade.value)) {
            mensagem = mensagem + " AS UNIDADES Produto deve ser numérico\n";
        }
        if (!campoNumerico(form.valor.value)) {
            mensagem = mensagem + " O PREÇO do Produto deve ser numérico\n";
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
