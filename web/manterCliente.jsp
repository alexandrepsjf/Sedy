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
                    <td> Cod. Cliente </td><td><input type="text" name="id" value="${cliente.id}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>       
                    </tr>
                    <tr>
                        <td>Data cadastro </td><td><input type="text" name="data_cadastro"  value="${cliente.dataCadastro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>           
                    <tr >
                        <td>Hora cadastro </td><td><input type="text" name="hora_cadastro"  value="${cliente.horaCadastro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td>(DDD)Telefone</td>
                        <td>                             
                            <select name="telefonesCliente" <c:if test="${operacao == 'Incluir'}"> disabled</c:if>>
                                <option value="">Selecione</option>
                            <c:forEach var="telefone" items="${telefones}">
                                <option value="${telefone.id}" <c:if test="${telefone.idCliente == cliente.id}"> selected</c:if>> ${telefone.numero} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td >${operacao} Telefone </td><td><input type="text" name="addTelefone" value="${telefone.numero}"  <c:if test="${operacao != 'Incluir'}"> hidden </c:if>></td>
                    </tr>
                    <tr>
                        <td> Id telefone</td><td><input type="text" name="addIdTelefone" value="${telefone.id}"  <c:if test="${operacao != 'Incluir'}"> hidden </c:if>></td>
                    </tr>
                    <tr> 
                        <td >Nome </td><td><input type="text" name="nome" value="${cliente.nome}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr> 
                        <td >Email </td><td><input type="text" name="email" value="${cliente.email}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Logradouro </td><td><input type="text" name ="rua" value="${cliente.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Numero </td><td><input type="text" name="numero" value="${cliente.numero}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr> 
                    <tr>
                        <td>Referência </td><td><input type="text" name ="referencia" value="${cliente.referenciaEndereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>                
                    <tr > 
                        <td >CEP </td><td><input type="text" name="cep" value="${cliente.cep}"></td>
                </tr>
                <tr>
                    <td> Bairro </td>                    
                    <td>                             
                        <select name="bairrocliente">
                            <option value="">Selecione</option>
                            <c:forEach var="bairro" items="${bairros}">
                                <option value="${bairro.id}" <c:if test="${cliente.idBairro == bairro.id}"> selected</c:if>> ${bairro.nome} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>     

            </table>
            <h3><button type="submit">Confirmar</button></h3>
        </form>
        <!--SCRIPT language="JavaScript">      

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

</SCRIPT-->
    </body>
</html>

