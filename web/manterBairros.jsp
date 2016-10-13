<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Bairros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Bairros - ${operacao}</h1></div>
        <table>            
            <tr> 
                <td colspan="2"> Cod. Bairro </td><td><input type="text" value="${bairro.id}" size="15"></td>
            </tr>
            <tr>
            <td colspan="2"> Nome Bairro </td><td><input type="text" value="${bairro.nome}" size="40"></td>
        </tr>
        <tr>
            <td colspan="2"> Taxa entrega do Bairro </td><td><input type="text" value="${bairro.taxa}" size="15"></td>
        </tr>
    </table>
    <h3><button>Confirmar</button></h3>
</body>
</html>
