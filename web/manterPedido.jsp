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
    <body class="keep">
        <title>cliente</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
<body>
    <div><h1>Pedido -  ${operacao}</h1></div>
    <div class="footer">
          &#9668; <a  href="ManterInicio"><button>Voltar</button></a> 
        </div>
    <form action="ManterPedidoController?acao=confirmar${operacao}" method="POST" name="frmManterPedido" onsubmit="return validarFormulario(this)">
        <table>  
            <tr>
                <td> USUARIO</td><td>
                    <select name="idUsuario" id="usuarios" <c:if test="${operacao != 'Incluir'}"> disabled</c:if>>
                            <option value="" >Selecione</option>
                        <c:forEach var="usuario" items="${usuarios}">
                            <option value="${usuario.id}" <c:if test="${pedido.idUsuario == usuario.id}"> selected</c:if> >  ${usuario.nome} </option>
                        </c:forEach>
                    </select>  </td>                              
            </tr>                     
            <tr>
                <td> COD. PEDIDO </td> <td> <input type="text"  name="id" value="${pedido.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>               
                </tr>
                <tr>
                    <td> DATA PEDIDO </td> <td><input type="text" name="data_2" value="${pedido.data_2}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td> HORA PEDIDO </td> <td> <input type="text" name="hora" value="${pedido.hora}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr> 
                <tr>
                    <td>CLIENTE</td><td>
                        <select name="idCliente" id="clientes" <c:if test="${operacao != 'Incluir'}"> disabled</c:if>>
                            <option value="" >Selecione</option>
                        <c:forEach var="cliente" items="${clientes}">
                            <option value="${cliente.id}" <c:if test="${pedido.idCliente == cliente.id}"> selected</c:if> >  ${cliente.nome} </option>
                        </c:forEach>
                    </select>
            </tr>  

            <!--tr>
                <td> QUANTIDADE </td> <td><input type="text" name="qtd" id="qtd"  > 
                </td>
            <tr>
                <td> PRODUTOS </td> 
                <td>
                    <select name="listaProdutos" id="listaProdutos">
                        <option value="" >Selecione</option>
            <c:forEach var="produto" items="${produtos}">
                <option value="${produto.id}" >  ${produto.nome} </option>
            </c:forEach>
        </select><input type="button" name="botao-ok" value="ADD"  onclick="addProduto();">
    </td>
</tr--> 
            <tr>                
                <td> FORMAS DE PGTO </td> 
                <td>                             
                    <select name="idFrmPgto">
                        <option value="">Selecione</option>
                        <c:forEach var="formaPagamento" items="${formaPagamentos}">
                            <option value="${formaPagamento.id}" <c:if test="${pedido.idFormaPgto == formaPagamento.id}"> selected</c:if>> ${formaPagamento.forma} </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td> VALOR TOTAL </td> <td><input type="text" id="teste" name="total" value="${pedido.total}" ></td>
            </tr>
            <tr>
                <td> DESCONTO </td> <td> <input type="text" name="desconto" ></td>
            </tr>
            <tr>
                <td> VALOR PAGO </td> <td><input type="text" name="valor_pago" ></td>
            </tr>
            <tr>
                <td> TROCO </td> <td><input type="text" name="troco"  ></td>                
            </tr>
        </table>
        <div class="footer">
            <button  type="submit" >Confirmar</button>
        </div>
    </form>
    <div class="logoSearch">            
    </div>        </form>
<!--h3><a href="ManterListaProdutosController?acao=prepararIncluir">Lista de produtos</a></h3>
<form action="ManterListaProdutosController?acao=prepararIncluir" method="POST">
    <h5> <input type="submit" name="btnIncluir" value="Incluir Produto"></h5> 
</form>
<form action="ManterListaProdutosController?acao=prepararEditar" method="POST">
    <h5> <input type="submit" name="btnIncluir" value="Editar Produto"></h5> 
</form>
<form action="ManterListaProdutosController?acao=prepararExcluir" method="POST">
    <h5> <input type="submit" name="btnIncluir" value="Excluir Produto"></h5> 
</form-->
<table id="tabela">
    <tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td></tr>
</table>
<SCRIPT language="JavaScript">
    function add() {
        alert("produto");
        /*
         id = produto.id;
         nome = produto.name;
         valorUnit = 
         totalUnit = 
         total = parseFloat(totalUnit);
         valor = parseFloat(valorUnit);
         valorTotal = (total * valor);
         tg = tg + total;
         vtg = vtg + valorTotal;
         vtgTemp = vtg.toFixed(2);
         vtgTemp = vtgTemp.toString();
         vtgTemp = vtgTemp.replace('.', ',');
         valorTotal = valorTotal.toFixed(2);
         valorTotal = valorTotal.toString();
         valorTotal = valorTotal.replace('.', ',');
         valorUnit = valorUnit.replace('.', ',');
         pedido = document.getElementById("tabela").innerHTML;
         document.getElementById("tabela").innerHTML = pedido + "<tr id='linha'><td>" + total + "</td><td>" + nome + "</td><td></td><td>" + valorUnit + "</td><td>" + valorTotal + "</td><td><button class='btn btn-success remove' onclick=\"remov(this)\">Excluir</button></td><tr>";
         // document.getElementById("tabelaFooter").innerHTML = " <tr ><td >" + tg + "</td><td ></td><td ></td><td > </td><td >" + vtgTemp + "</td><td></td></tr>";
         */}

    function addProduto() {
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
            mensagem = mensagem + "Informe o Código do Pedido\n";
        }
        if (form.data_2.value == "") {
            mensagem = mensagem + "Informe a DATA do Pedido\n";
        }
        if (form.hora.value == "") {
            mensagem = mensagem + "Informe a HORA do Pedido\n";
        }
        if (form.total.value == "") {
            mensagem = mensagem + "Informe o VALOR TOTAL do Pedido\n";
        }


        if (!campoNumerico(form.id.value)) {
            mensagem = mensagem + "Código do Pedido deve ser numérico\n";
        }
        if (!campoNumerico(form.data_2.value)) {
            mensagem = mensagem + "A DATA do Pedido deve conter somente números\n";
        }
        if (!campoNumerico(form.hora.value)) {
            mensagem = mensagem + "A HORA do Pedido deve conter somente números\n";
        }
        if (!campoNumerico(form.total.value)) {
            mensagem = mensagem + "O VALOR TOTAL do Pedido deve conter somente números\n";
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
