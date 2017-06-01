<%@page contentType="text/html" pageEncoding="utf-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Pesquisa de Relatorios</title>
       <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta Name="robots" content="index">
    <meta Name="robots" content="follow">
    <meta name="author" content="Alexandre de Paula Santos">
    <meta name="author" content="Icaro Alvarenga">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/google-fonts.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/css.css"> 
    </head>
    <body class="search">

        <div class="title"><h1>Pesquisa de Relatórios</h1></div>

        <div class="footer"> 
            &#9668; <a href="ManterInicio"><button>inicio</button></a>    
        </div>       
        <div class="logoSearch">            
        </div>
        <form  action="ManterRelatorioController" method="POST">  
            <table  class="table" >            
                <tr> 
                    <th>Tipo do relatorio</th>
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
                                Telefones
                            </option>
                            <option>
                                Ligacoes
                            </option>
                        </select>
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
        function changeParameter(Emailsreport) {
            var opcao = report.valueOf().value;
            var selection = document.getElementById("reportParameter");
            switch (opcao)
            {
                case 'Clientes' :
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Nome</td><td><input type='text'  name=\"reportParameter1\"></td></tr><tr><td>Rua</td><td><input type='text'name=\"reportParameter2\"></td></tr><tr><td>Numero</td><td><input type='text' name=\"reportParameter3\"></td></tr><tr><td>Bairro</td><td><input type='text' name=\"reportParameter4\"></td></tr><tr><td>CEP</td><td><input type='text' name=\"reportParameter5\"></td></tr><tr><td>Data de cadastro</td><td><input type='text'  placeholder='aaaa-mm-dd' name=\"reportParameter6\"><input type='hidden' name='numParameter' value='6'></td></tr>";
                    break;

                case 'Pedidos':
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Nome</td><td><input type='text' name=\"reportParameter1\"></td></tr><tr><td>Data</td><td><input type='text' name=\"reportParameter2\"></td></tr><tr><td>Data</td><td><input type='text' name=\"reportParameter3\"></td></tr><tr><td>Total</td><td><input type='text' name=\"reportParameter4\"><input type='hidden' name='numParameter' value='4'></td></tr>";
                    break;

                case 'Bairros':
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Id</td><td><input type='text' name=\"reportParameter1\"></td></tr><tr><td>Bairro</td><td><input type='text' name=\"reportParameter2\"></td></tr><tr><td>Taxa</td><td><input type='text' name=\"reportParameter3\"><input type='hidden' name='numParameter' value='3'></td></tr>";
                    break;
                case 'Produtos':
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Id</td><td><input type='text' name=\"reportParameter1\"></td></tr><tr><td>Nome</td><td><input type='text' name=\"reportParameter2\"></td></tr><tr><td>Unidade</td><td><input type='text' name=\"reportParameter3\"></td></tr><tr><td>Valor</td><td><input type='text' name=\"reportParameter4\"><input type='hidden' name='numParameter' value='4'></td></tr>";
                    break;
                case 'Formas de pgto' :
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Id</td><td><input type='text'  name=\"reportParameter1\"></td></tr><tr><td>Forma</td><td><input type='text'name=\"reportParameter2\"></td><input type='hidden' name='numParameter' value='2'></td></tr>";
                    break;

                case 'Niveis':
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Id</td><td><input type='text' name=\"reportParameter1\"></td></tr><tr><td>Nivel</td><td><input type='text' name=\"reportParameter2\"><input type='hidden' name='numParameter' value='2'></td></tr>";
                    break;

                case 'Usuarios':
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Usuario</td><td><input type='text' name=\"reportParameter1\"></td></tr><tr><td>Login</td><td><input type='text' name=\"reportParameter2\"></td></tr><tr><td>Nome</td><td><input type='text' name=\"reportParameter3\"><input type='hidden' name='numParameter' value='3'></td></tr>";
                    break;
                
                case 'Telefones':
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Nome</td><td><input type='text' name=\"reportParameter1\"></td></tr><tr><td>Telefone</td><td><input type='text' name=\"reportParameter2\"><input type='hidden' name='numParameter' value='2'></td></tr>";
                    break;
                case 'Chamadas Recebidas':
                    document.getElementById("reportParameter").innerHTML = " <th>Parâmetro do relatòrio<td>Deixe em branco p/ completo</td></th> <tr><td>Id</td><td><input type='text'></td></tr><tr><td>Nome</td><td><input type='text'></td></tr><tr><td>Unidade</td><td><input type='text'></td></tr><tr><td>Valor</td><td><input type='text'></td></tr>";
                    break;
                default:
                    break;
            }
        }
    </script>
</html>