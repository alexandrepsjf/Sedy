<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Formas pgto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Formas Pagamento</h1></div>
        <table>            
            <tr> 
                <td colspan="2"> Cod. Forma pgto </td><td><input type="text" size="15" value="${formaPagamento.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
            </tr>

            <td colspan="2"> Nome Forma pgto </td> <td><input type="text" size="40" value="${formaPagemto.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
        </tr>
    </table>
    <h3><button>Confirmar</button></h3>
</body>
</html>
