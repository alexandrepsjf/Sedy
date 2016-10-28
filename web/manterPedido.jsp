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
                    <td> COD. CLIENTE </td> <td> <input type="text"  name="id" value="${pedido.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>               
                    </tr>            
                    <tr>
                        <td> TELEFONE DDD </td> <td> <select>                       
                            </select>                
                            <select>            

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> DATA PEDIDO </td> <td><input type="text" name="data_2" value="${pedido.data_2}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td> HORA PEDIDO </td> <td> <input type="text" name="hora" value="${pedido.hora}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    </tr>            
                    <tr>   

                        <td > NOME </td> <td><input type="text" name="nome" value="${pedido.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td> OBSERVAÇÃO </td> <td> <input type="text" name="obs" value="${pedido.observacao}">    </td>
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
                        <select >            
                            <option></option>
                            <option></option>
                            <option></option>                       
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> VALOR </td> <td><input type="text" ></td>
                </tr>
                <tr>
                    <td> DESCONTO </td> <td><input type="text" ></td>
                </tr>
                <tr>                
                    <td> FORMAS DE PGTO </td> <td> <select>                             
                        </select> </td>
                </tr>
                <tr>
                    <td> VALOR TOTAL </td> <td><input type="text" ></td>
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
        <table>
            <tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td><td>OBS.</td><td>EDITAR</td></tr>
        </table>
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
            //-->
        </SCRIPT>            
    </body>    
</html>
