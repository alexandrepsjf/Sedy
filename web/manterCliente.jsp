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
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Cliente -  ${operacao}</h1></div>
        <form action="ManterClienteController?acao=confirmar${operacao}" method="post" name="frmManterCliente" >
        <table> 
            <tr> 
                <td>Data cadastro <input type="text" value="${cliente.data_cadastro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr>
                <td>Hora cadastro <input type="text" value="${cliente.hora_cadastro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td colspan="2"> Cod. Cliente <input type="text" value="${cliente.id}" size="15" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>       

                </tr>
                <tr> 
                    <td>(DDD)Telefone
                        <select name="optTel" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${cliente.telefone.telefone == null}"> selected</c:if>> </option>  
                        <c:forEach items="${cliente}" var="cliente">
                            <option value="${cliente.id}" <c:if test="${cliente.telefone.telefone == cliente.telefone}"> selected</c:if>>${cliente.telefone}</option>  
                        </c:forEach>
                    </select>                           
                </td>
            </tr>
            <tr> 
                <td colspan="2">Nome <input type="text" value="${telefone.nome}" size="40" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td colspan="2">Email <input type="text" value="${cliente.email}" size="40" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td colspan="2">Logradouro
                        <select>            
                            <option>Rua</option>
                            <option>Avenida</option>
                            <option>Praça</option>
                            <option></option>
                        </select>
                        <input type="text" size="40"></td>
                </tr>
                <tr>
                    <td>Numero <input type="text" value="${cliente.numero}" size="15"></td>
            </tr> 
            <tr>
                <td>Referência<input type="text"></td>
                <td>Complemento <input type="text"></td>
            </tr>
            <tr> 
                <td>CEP  <input type="text"></td>            
                <td> Bairro  <select name="optTel" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${cliente.bairro.nome == null}"> selected</c:if>> </option>  
                        <c:forEach items="${bairro}" var="bairro">
                            <option value="${cliente.id}" <c:if test="${cliente.bairro.nome == cliente.bairro}"> selected</c:if>>${cliente.bairro}</option>  
                        </c:forEach>
                    </select>  
                </td>
                <td><button>Cadastrar bairro</button></td>
            </tr>
            <tr>
                <td>Cidade <input type="text"></td>
                <td>Estado <input type="text">
                </td>
            </tr>        
        </table>

        <h3><button type="submit">Confirmar</button></h3>
        </form>
    </body>
</html>
