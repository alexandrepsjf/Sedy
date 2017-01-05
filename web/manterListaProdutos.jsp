<%-- 
    Document   : listaProdutos
    Created on : 17/11/2016, 15:07:45
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
    <body class="keep">
        <title>Lista de produtos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
<body >
    <div><h1>Lista produtos -  ${operacao}</h1></div>
    <form action="ManterListaProdutosController?acao=confirmar${operacao}" method="POST" name="frmManterListaProdutos" onsubmit="return validarFormulario(this)" >
        <table>  
            <tr>
                <td> COD. LISTA DE PRODUTOS </td> <td> <input type="text"  name="id" value="${listaProdutos.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>               
                </tr>       
                <tr>
                    <td> QUANTIDADE </td> <td><input type="text" id="qtd" name="qtd"> 
                    </td>
                <tr>
                    <td> PRODUTO </td> 
                    <td>
                        <select  id="listaProdutos">
                            <option value="" >Selecione</option>
                        <c:forEach var="produto" items="${produtos}">
                            <option value="${produto.id}" onclick="addProduto(this)"> ${produto.nome} </option>
                        </c:forEach>
                    </select><input type="button" name="botao-ok" value="ADD"  onclick="addProduto();">
                </td>
            </tr>                         
        </table>
        <div class="footer">
            <button  type="submit" >Confirmar</button>
        </div>
    </form>
    <div class="logoSearch">            
    </div>        </form>       
<table id="tabelaProdutos">
    <tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td><td>OBS.</td><td>EDITAR</td></tr>
</table>
<script>
    function addProduto() {
        alert("teste");
        var qtd = document.getElementById("qtd").value;
        if (qtd != "") {
            var combobox = document.getElementById("listaProdutos");
            var i = combobox.selectedIndex;
            var texto = document.getElementById("listaProdutos").options[i].text;
            var index = document.getElementById("listaProdutos").options[i].value;
    <c:forEach var="produto" items="${produtos}">
            cod = ${produto.id};
            if (cod == index) {
                var valor = ${produto.valor};
                var nome = "${produto.nome}";
            }
    </c:forEach>
            var pedido = document.getElementById("tabela").innerHTML;
            document.getElementById("tabela").innerHTML = pedido + "<tr><td>" + cod + "</td><td>" + qtd + "</td><td>" + nome + "</td><td>" + valor + "</td><td>" + (qtd * valor) + "</td></tr>";
            document.getElementById("qtd").value = "";
        } else {
            alert("Digite uma quantidade");
        }
    }
</script>
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
            function validarFormulario(form){
            var mensagem;
                    mensagem = "";
                    if (form.id.value === ""){
            mensagem = mensagem + "Informe o Código do Produto\n";
            }
            if (!campoNumerico(form.id.value)){
            mensagem = mensagem + "Código do Produto deve ser numérico\n";
            }
            if (mensagem === ""){
            return true;
            } else{
            alert(mensagem);
                    return false;
            }
            //-->
            < /body>
                    < /html>
