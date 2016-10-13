<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>       

        <div><h1>Produto - ${operacao}</h1></div>
        <table>            
            <tr> 
                <td colspan="2"> Cod. Produto </td><td><input type="text" value="${produto.id}" size="15"></td>
            </tr>
            <tr>
            <td colspan="2"> Nome Produto </td><td><input type="text" value="${produto.nome}" size="40"></td>
        </tr>
        <tr>
            <td colspan="2"> Preço produto </td><td><input type="text" value="${produto.valor}" size="15"></td>
        </tr>
    </table>
    <h3><button>Confirmar</button></h3>
    </body>

</html>
