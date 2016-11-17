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
    <body>
        <div><h1>LIsta produtos -  ${operacao}</h1></div>
        <form action="ManterListaProdutosController?acao=confirmar${operacao}" method="POST" name="frmManterListaProdutos" >
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
                    <td> PRODUTO </td> 
                    <td>
                        <select  onclick="addProduto(this)">
                            <option value="" >Selecione</option>
                            <c:forEach var="produto" items="${produtos}">
                                <option value="${produto.id}" onclick="addProduto(this)"> ${produto.nome} </option>
                            </c:forEach>
                        </select>
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
                    <td> VALOR TOTAL </td> <td><input type="text" value="${pedido.total}"></td>
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
            <h3><button type="submit">Confirmar</button></h3>
        </form>       
        <table id="tabelaProdutos">
            <tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td><td>OBS.</td><td>EDITAR</td></tr>
        </table>
    </body>
</html>
