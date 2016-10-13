<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Pedido -  ${operacao}</h1></div>
        <table>            
            <tr>
                <td>Codigo cliente <input type="text" size="5"></td>                
                <td>Esse pedido será: Entregue <input name="entrega" type="radio">
             Retirado <input name="entrega" type="radio"></td> 
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
                <td>Data Pedido <input type="date"></td>
                 <td>Hora Pedido <input type="time"></td>
                <td><button>Ultimo Pedido</button></td>
            </tr>            
            <tr>     
                
                <td colspan="2">Nome <input type="text" size="40"></td>
                <td>Observações <textarea>
                    </textarea></td>
            </tr>
            <tr>
                <td>Codigo Produto <input type="text" size="20"></td>
                <td>QTD<input type="number" min="1" max="10"> Produto                
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
        <table>
            <tr><td>COD</td><td>QTDE</td><td>PRODUTO</td><td>V.UNIT</td><td>V.TOTAL</td><td>OBS.</td><td>EDITAR</td></tr>
               
        </table>
        <h3><button>Incluir Pedido</button></h3>
    </body>
</html>
