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
        <title>cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Pedido -  ${operacao}</h1></div>
        <form action="ManterPedidoController?acao=confirmar${operacao}" method="POST" name="frmManterPedido" >
            <table>  
                <tr>
                    <td> COD. USUARIO </td> <td> <input type="text"  name="idUsuario" value="${pedido.idUsuario}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>               
                    </tr> 
                    <tr>
                        <td> NOME USUARIO </td> <td> <input type="text"  name="nomeUsuario" value="${pedido.usuario.nome}"<c:if test="${operacao != 'teste'}"> readonly</c:if>></td>               
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

                        <td > Cod. CLIENTE </td> <td><input type="text" name="idCliente" value="${pedido.cliente.id}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>   

                        <td > NOME CLIENTE </td> <td><input type="text" name="nome" value="${pedido.cliente.nome}"<c:if test="${operacao != 'teste'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td> OBSERVAÇÃO </td> <td> <input type="text" name="obs" value="">    </td>
                    </tr>
                    <tr>
                        <!--REAVALIAR SITUAÇÃO DOS CAMPOS ABAIXO DE UMA FORMA QUE PODEMOS TRABALHAR DE UMA FORMA CERTA -->
                        <td > COD.PRODUTO </td> <td><input type="text" ></td>
                    </tr>
                    <tr>
                        <td> QUANTIDADE </td> <td><input type="number" name="qtd" min="1" max="10" > 
                        </td>
                    <tr>
                        <td> PRODUTOS </td> 
                        <td>
                            <select>
                                <option value="" >Selecione</option>
                            <c:forEach var="produto" items="${produtos}">
                                <option value="${produto.id}" >  ${produto.nome} </option>
                            </c:forEach>
                        </select><input type="button" name="botao-ok" value="ADD" onclick="addProduto();">
                        </td>
                </tr>        

                <tr>                
                    <td> FORMAS DE PGTO </td> 
                    <td>                             
                        <select name="idFrmPgto">
                            <option value="">Selecione</option>
                            <c:forEach var="formaPagamento" items="${formaPagamentos}">
                                <option value="${formaPagamento.id}" <c:if test="${usuario.idNivel == nivel.id}"> selected</c:if>> ${formaPagamento.forma} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> VALOR TOTAL </td> <td><input type="text" id="teste"  value="${pedido.total}" ></td>
                </tr>
                <tr>
                    <td> DESCONTO </td> <td> <input type="text"></td>
                </tr>
                <tr>
                    <td> VALOR PAGO </td> <td><input type="text" ></td>
                </tr>
                <tr>
                    <td> TROCO </td> <td><input type="text" ></td>                
                </tr>
            </table>
            <h5><button type="submit">Confirmar</button></h5>
        </form>
        <!--form action="ManterListaProdutosController?acao=prepararIncluir" method="POST">
            <h5> <input type="submit" name="btnIncluir" value="Incluir Produto"></h5> 
        </form>
        <form action="ManterListaProdutosController?acao=prepararEditar" method="POST">
            <h5> <input type="submit" name="btnIncluir" value="Editar Produto"></h5> 
        </form>
        <form action="ManterListaProdutosController?acao=prepararExcluir" method="POST">
            <h5> <input type="submit" name="btnIncluir" value="Excluir Produto"></h5> 
        </form-->
        <table id="tabela">
            <tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td><td>OBS.</td><td>EDITAR</td></tr>
        </table>
        <SCRIPT language="JavaScript">
            function add(produto) {
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
                alert("produto.id");
                 pedido = document.getElementById("tabela").innerHTML;
                document.getElementById("tabela").innerHTML = pedido+ "<tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td><td>OBS.</td><td>EDITAR</td></tr>";


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
                if (form.txtCodPedido.value == "") {
                    mensagem = mensagem + "Informe o Código do Pedido\n";
                }

                if (!campoNumerico(form.txtCodPedido.value)) {
                    mensagem = mensagem + "Código do Pedido deve ser numérico\n";
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
