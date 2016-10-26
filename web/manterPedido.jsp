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
                <td>Codigo cliente <input type="text" size="5" name="id" value="${pedido.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>               
       
            </tr>            
            <tr>
                <td> Telefone DDD <select>            
                        <option>032</option>
                        <option>033</option>
                        <option>034</option>
                        <option>035</option>
                    </select>                 
                <select>            
                        <option>3222-2222</option>
                        <option></option>
                        <option></option>
                        <option></option>
                    </select>
                </td>
                <td>Data Pedido <input type="date" name="data_2" value="${pedido.data_2}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                 <td>Hora Pedido <input type="time" name="hora" value="${pedido.hora}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                <td><button>Ultimo Pedido</button></td>
            </tr>            
            <tr>     
                
                <td colspan="2">Nome <input type="text" size="40" name="nome" value="${pedido.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                <td>Observações <textarea>
                    </textarea></td>
            </tr>
            <tr>
                <!--REAVALIAR SITUAÇÃO DOS CAMPOS ABAIXO DE UMA FORMA QUE PODEMOS TRABALHAR DE UMA FORMA CERTA -->
                <td>Codigo Produto <input type="text" size="20"></td> 
                <td>QTD<input type="number" min="1" max="10" > Produto                
                    <select >            
                        <option></option>
                        <option></option>
                        <option></option>                       
                    </select></td>
               <td>VALOR <input type="text" size="8"></td>
               <td>DESCONTO <input type="text" size="8"></td>
               <td><button>Incluir</button>                
                <button>Excluir</button>
                </td>
            </tr>
            <tr>                
                <td> Formas de Pgto <select>            
                        <option>Cartaoo</option>
                        <option>Dinheiro</option>
                        <option>Fiado</option>
                        <option></option>
                    </select> </td>
                    <td>VALOR TOTAL <input type="text" size="8"></td>
               <td>DESCONTO <input type="text" size="8"></td>
               <td>VALOR PAGO<input type="text" size="8"></td>
               <td>TROCO <input type="text" size="8"></td>                
            </tr>  
            <tr>
                <td><button>Acrescimos</button>
                <button>Ingredientes</button>
                <button>Imprimir</button></td>
                
            </tr>

        </table>
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
                if (form.txtCodPedido.value == ""){
                    mensagem = mensagem + "Informe o Código do Pedido\n";
                }                             
                
                if (!campoNumerico(form.txtCodPedido.value)){
                    mensagem = mensagem + "Código do Pedido deve ser numérico\n";
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
        <table>
            <tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td><td>OBS.</td><td>EDITAR</td></tr>
               
        </table>
        <h3><button>Incluir Pedido</button></h3>
    </body>
</html>
