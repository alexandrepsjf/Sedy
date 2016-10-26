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
            <table   style="text-align:right;"> 
                <tr > 
                    <td >Data cadastro <input type="text" name="data_cadastro" size="10" value="${cliente.data_cadastro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                              
                    <tr >
                        <td>Hora cadastro <input type="text" name="hora_cadastro" size="10" value="${cliente.hora_cadastro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr > 
                        <td> Cod. Cliente <input type="text" name="id" size="10" value="${cliente.id}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>       
                    </tr>
                    <tr> 
                        <td>(DDD)Telefone
                           <!--select name="optTel" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${cliente.telefone.telefone == null}"> selected</c:if>> </option>  
                            <c:forEach items="${telefones}" var="cliente">
                                <option value="${cliente.id}" <c:if test="${cliente.telefone.telefone == cliente.telefone}"> selected</c:if>>${cliente.telefone}</option>  
                            </c:forEach>
                        </select-->                           
                    </td>
                </tr>
                <tr> 
                    <td >Nome <input type="text" name="nome" value="${cliente.nome}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td >Email <input type="text" name="email" value="${cliente.email}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Logradouro<input type="text" name ="logradouro" value="${cliente.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Numero <input type="text" name="numero" value="${cliente.numero}" size="15" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr> 
                <tr>
                    <td>Referência<input type="text" name ="referencia" value="${cliente.referencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Compl. <input type="text" name="complemento" value="${cliente.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr > 
                    <td >CEP  <input type="text" value="${cliente.cep}"></td>
                </tr>
                <tr>
                    <td> Bairro  <!--select name="optTel" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${cliente.bairro.nome == null}"> selected</c:if>> </option>  
                            <c:forEach items="${bairros}" var="bairro">
                                <option value="${cliente.id}" <c:if test="${cliente.bairro.nome == cliente.bairro}"> selected</c:if>>${cliente.bairro}</option>  
                            </c:forEach>
                        </select-->  
                    </td>
                </tr>               
                <tr>
                    <td>Cidade <input type="text" name="cidade" value="${cliente.cidade}"></td>
                </tr>
                <tr>
                    <td>Estado <input type="text" name="estado" value="${cliente.estado}">
                    </td>
                </tr>        
            </table>
            <h3><button type="submit">Confirmar</button></h3>
        </form>
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
                if (form.txtCodCliente.value == ""){
                    mensagem = mensagem + "Informe o Código do Cliente\n";
                }
                if (form.txtNumero.value == ""){
                    mensagem = mensagem + "Informe o Numero do Cliente\n";
                }
                if (form.txtTelefone.value == ""){
                    mensagem = mensagem + "Informe o Numero do Cliente\n";
                }
                if (!campoNumerico(form.txtCodCliente.value)){
                    mensagem = mensagem + "Código do Cliente deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtNumero.value)){
                    mensagem = mensagem + "O Numero deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtTelefone.value)){
                    mensagem = mensagem + "O Telefone deve ser numérico\n";
                }                  
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            //-->
        </SCRIPT>
    </body>
</html>

