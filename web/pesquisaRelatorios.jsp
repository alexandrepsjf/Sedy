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
        <title>Pesquisa de Relatorios</title>
        <meta http-equiv="content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">   
    </head>
    <body class="search">

        <div class="title"><h1>Pesquisa de Relatórios</h1></div>
        <div class="footer"> 
            &#9668; <a href="ManterInicio"><button>inicio</button></a>    
        </div>       
        <div class="logoSearch">            
        </div>
        <form  action="RelatorioBairroController" method="POST">  
            <table  class="table" >            
                <tr> 
                    <th>Tipo do relatorio</th>
                    <th>Parâmetro do relatòrio</th>                             
                </tr>

                <tr>
                    <td>
                        <select name="reportName" onChange=changeParameter(this)>
                            <option>

                            </option>
                            <option>
                                Clientes
                            </option>
                            <option>
                                Pedidos
                            </option>
                            <option>
                                Bairros
                            </option>
                            <option>
                                Produtos
                            </option>
                            <option>
                                Formas de pgto
                            </option>
                            <option>
                                Niveis
                            </option>
                            <option>
                                Usuarios
                            </option>
                            <option>
                                Emails
                            </option>
                            <option>
                                Telefones
                            </option>
                            <option>
                                Ligacoes
                            </option>
                        </select>
                    </td>
                    <td>
                    </td>
                </tr>                
            </table> 
            <table id ="reportParameter" name="reportParameter" class="table">
                
            </table>
            <div class="footer">  
                <input  type="submit" name="btnIncluir" value="Gerar">
                </form>

            </div>

    </body>
    <script>
        function changeParameter(report) {
            var opcao = report.valueOf().value;
            var selection = document.getElementById("reportParameter");
                        switch (opcao)
            {
                case 'Clientes' :
                    document.getElementById("reportParameter").innerHTML = "<tr><td>Nome</td><td><input type='text'  name=\"reportParameter1\"></td></tr><tr><td>Rua</td><td><input type='text'name=\"reportParameter2\"></td></tr><tr><td>Numero</td><td><input type='text' name=\"reportParameter3\"></td></tr><tr><td>Bairro</td><td><input type='text' name=\"reportParameter4\"></td></tr><tr><td>CEP</td><td><input type='text' name=\"reportParameter5\"></td></tr><tr><td>Data de cadastro</td><td><input type='text' name=\"reportParameter6\"><input type='hidden' name='numParameter' value='6'></td></tr>";
                    break;

                case 'Pedidos':
                    document.getElementById("reportParameter").innerHTML = "<tr><td>Nome</td><td><input type='text'></td></tr><tr><td>Rua</td><td><input type='text'></td></tr><tr><td>Numero</td><td><input type='text'></td></tr><tr><td>Bairro</td><td><input type='text'></td></tr><tr><td>CEP</td><td><input type='text'></td></tr><tr><td>Data de cadastro</td><td><input type='text'></td></tr>";
                    break;

                case 'Bairros':
                    document.getElementById("reportParameter").innerHTML = "<tr><td>Nome</td><td><input type='text'></td></tr><tr><td>Rua</td><td><input type='text'></td></tr><tr><td>Numero</td><td><input type='text'></td></tr><tr><td>Bairro</td><td><input type='text'></td></tr><tr><td>CEP</td><td><input type='text'></td></tr><tr><td>Data de cadastro</td><td><input type='text'></td></tr>";
                    break;
                    case 'Produtos':
                    document.getElementById("reportParameter").innerHTML = "<tr><td>Id</td><td><input type='text'></td></tr><tr><td>Nome</td><td><input type='text'></td></tr><tr><td>Unidade</td><td><input type='text'></td></tr><tr><td>Valor</td><td><input type='text'></td></tr>";
                    break;

                default:
                    break;
            }
        }
    </script>
</html>