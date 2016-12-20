<%-- 
    Document   : listaProdutos
    Created on : 17/11/2016, 15:07:45
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
    <head>
        <title>Lista de produtos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body >
        <div><h1>Lista produtos -  ${operacao}</h1></div>
        <form action="ManterListaProdutosController?acao=confirmar${operacao}" method="POST" name="frmManterListaProdutos" >
            <table>  
                <tr>
                    <td> COD. LISTA DE PRODUTOS </td> <td> <input type="text"  name="id" value="${listaProdutos.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>               
                    </tr>                       
                    <tr>
                        <td> COD. PEDIDO </td> <td> <input type="text"  name="idPedido" value="${listaProdutos.idPedido}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>               
                    </tr>
                    <tr> 
                        <td > NOME CLIENTE </td> <td><input type="text" name="nome" value="${pedido.cliente.nome}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
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
                    <h3><button type="submit" onclick="addProduto();">Confirmar</button></h3>
        </form>       
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
    </body>
</html>
