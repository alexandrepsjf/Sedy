<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Cliente -  ${operacao}</h1></div>
        <table> 
            <tr> 
                <td>Data cadastro <input type="text" value="${cliente.data_cadastro}"></td><td>Hora cadastro <input type="time"></td>
            </tr>
            <tr> 
                <td colspan="2"> Cod. Cliente <input type="text" value="${cliente.id}" size="15"></td>
            </tr>
            <tr> 
                <td>DDD <select>            
                        <option>032</option>
                        <option>033</option>
                        <option>034</option>
                        <option>035</option>
                    </select>
                    Telefone <select>            
                        <option>3222-2222</option>
                        <option></option>
                        <option></option>
                        <option></option>
                    </select>
                </td>
            </tr>
            <tr> 
                <td colspan="2">Nome <input type="text" value="${bairro.nome}" size="40"></td>
            </tr>
            <tr> 
                <td colspan="2">Email <input type="text" value="${bairro.email}" size="40" ></td>
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
                <td>Numero <input type="text" value="${bairro.numero}"></td>
            </tr> 
            <tr>
                <td>Referência <textarea >
                    </textarea></td>
                <td>Complemento <select>            
                        <option>casa</option>
                        <option>bloco</option>
                        <option></option>
                        <option></option>
                    </select>
                    <input type="text"></td>
            </tr>
            <tr> 
                <td>CEP  <input type="text"></td>            
                <td> Bairro <select>            
                        <option>Bom Pastor</option>
                        <option>Santa Luzia</option>
                        <option></option>
                        <option></option>
                    </select> </td>
                <td><button>Cadastrar bairro</button></td>
            </tr>
            <tr>
                <td>Cidade <select>            
                        <option>Juiz de Fora</option>
                        <option>Barbacena</option>
                        <option></option>
                        <option></option>
                    </select>
                </td>
                <td>Estado  <select>            
                        <option>Minas Gerais</option>
                        <option>Rio de Janeiro</option>
                        <option></option>
                        <option></option>
                    </select>
                </td>
            </tr>        
        </table>

        <h3><button>Confirmar</button></h3>
    </body>
</html>
