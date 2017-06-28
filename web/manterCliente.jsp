
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
        <title>Cliente</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
    </head>
    <body class="keep">
        <div><h1>Cliente -  ${operacao}</h1></div>
        <div class="footer">
          &#9668; <a  href="ManterInicio"><button>Voltar</button></a> 
        </div>
        <form action="ManterClienteController?acao=confirmar${operacao}" method="post" name="frmManterCliente"  >
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
                        
                    </td>
                </tr>
                <tr>
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
                                <option value="${bairro.id}" <c:if test="${cliente.bairroId.id == bairro.id}"> selected</c:if>> ${bairro.bairro} </option>
                            </c:forEach>
                        </select>
                    </td>
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

        function validarFormulario(form) {
            var mensagem;
            mensagem = "";
            if (form.id.value === "") {
                mensagem = mensagem + "Informe o CÓDIGO DO CLIENTE \n";
            }
            if (form.data_cadastro.value === "") {
                mensagem = mensagem + "Informe A DATA DO CLIENTE \n";
            }
            if (form.data_cadastro.value === "") {
                mensagem = mensagem + "Informe A HORA DO CLIENTE \n";
            }
            if (form.addTelefone.value === "") {
                mensagem = mensagem + "Informe TELEFONE DO CLIENTE \n";
            }
            if (form.numero.value === "") {
                mensagem = mensagem + "Informe NUMERO DO CLIENTE \n";
            }
            if (form.cep.value === "") {
                mensagem = mensagem + "Informe CEP DO CLIENTE \n";
            }

            if (!campoNumerico(form.id.value)) {
                mensagem = mensagem + "CÓDIGO DO CLIENTE deve ser numérico\n";
            }
            if (!campoNumerico(form.data_cadastro.value)) {
                mensagem = mensagem + "DATA DO CLIENTE deve ser numérico\n";
            }
            if (!campoNumerico(form.hora_cadastro.value)) {
                mensagem = mensagem + "HORA DO CLIENTE deve ser numérico\n";
            }
            if (!campoNumerico(form.addTelefone.value)) {
                mensagem = mensagem + "TELEFONE DO CLIENTE deve ser numérico\n";
            }
            if (!campoNumerico(form.numero.value)) {
                mensagem = mensagem + "NUMERO DO CLIENTE deve ser numérico\n";
            }
            if (!campoNumerico(form.cep.value)) {
                mensagem = mensagem + "CEP DO CLIENTE deve ser numérico\n";
            }

            if (mensagem === "") {
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
