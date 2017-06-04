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
    <body class="">

        <nav class="nav-extended teal lighten-3">
            <div class="nav-wrapper">
                <a href="ManterInicio" class=" brand-logo center mylogo shadowOrange blue-text">SEDY</a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li>
                        <a href="PesquisaRelatorioController">
                            <i class="large teal-text material-icons shadowOrange tooltipped  " data-position="bottom" data-delay="50"
                               data-tooltip="RELATÓRIOS">print</i>
                        </a>
                    </li>
                    <li>
                        <a class=" waves-effect">
                            <i class="large teal-text material-icons shadowOrange tooltipped" data-position="bottom" data-delay="50"
                               data-tooltip="SAIR">room</i>                        
                        </a>
                    </li>
                </ul>                
            </div>
        </nav>
        <main class="  ">
            <h4 class=" teal-text shadowOrange center">Sistema de entregas delivery</h4>
            <div class="center">
                <h5>Pesquisa de Relatórios</h5>
            </div>
            <div class=" row col s12  center ">
                <form  action="ManterRelatorioController" method="POST" class=" offset-s4 col s6 center">              

                    <div class="input-field offset-s1  col s6 ">
                        <select name="reportName" onChange=changeParameter(this)>
                            <option value="" disabled selected>Escolha uma opção</option>
                            <option>Clientes</option>
                            <option>Pedidos</option>
                            <option>Bairros</option>
                            <option>Produtos</option>
                            <option>Formas de pgto</option>
                            <option>Niveis</option>
                            <option>Usuarios</option>
                            <option>Telefones</option>
                            <option>Ligações</option>
                        </select>
                        <label> Tipo do relatorio</label>
                    </div>  
                    <div class="center">
                        <table id ="reportParameter" name="reportParameter" class="table highlight centered ">
                            
                        </table>
                    </div>
                    <div class="btn waves-effect waves-purple center">                         
                        <input  type="submit" name="btnIncluir" value="Gerar">
                    </div>
                </form>
            </div>
        </main>
    </body>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <!--js extra-->
    <script type="text/javascript" src="js/app.js"></script>
    <script type="text/javascript">
    </script>
    <script>
        function changeParameter(report) {
            var opcao = report.valueOf().value;
            var selection = document.getElementById("reportParameter");

            switch (opcao)
            {
                case 'Clientes' :
                    document.getElementById("reportParameter").innerHTML = " <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th></tr></thead><tbody><tr><td class='input-field'><input  type='text' class='validate' id='nome' name='reportParameter1'><label for='nome'>Nome</label></td></tr><tr><td class='input-field'><input class='validate' id='rua' type='text'name='reportParameter2'><label for='rua'>Rua</label></td></tr><tr><td class='input-field'><input type='text'class='validate' id='Numero' name='reportParameter3'><label for='Numero'>Numero</label></td></tr><tr><td class='input-field'><input type='text' class='validate' id='Bairro' name='reportParameter4'><label for='Bairro'>Bairro</label></td></tr><tr><td class='input-field'><input type='text' class='validate' id='CEP' name='reportParameter5'><label for='CEP'>CEP</label></td></tr><tr><td class='input-field'><input type='text' class='validate' id='data' placeholder='aaaa-mm-dd' name='reportParameter6'><label for='data'>Data de cadastro</label><input type='hidden' name='numParameter' value='6'></td></tr>";
                            break;

                case 'Pedidos':
                    document.getElementById("reportParameter").innerHTML = " <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead><tbody><tr><td class='input-field'><input type='text' class='validate' id='nome' name='reportParameter1'><label for='nome'>Nome</label></td></tr>"+
                            "<tr><td class='input-field'><input class='validate' id='forma' type='text' name='reportParameter2'><label for='forma'>Forma</label></td></tr>"+
                            "<tr><td class='input-field'><input class='validate' id='data' type='text' name='reportParameter4'><label for='data'>Data</label></td></tr>"+
                            "<tr><td class='input-field'><input type='text' class='validate' id='total' name='reportParameter4'><label for='total'>Total</label><input type='hidden' name='numParameter' value='4'></td></tr>";
                    break;

                case 'Bairros':
                    document.getElementById("reportParameter").innerHTML = " <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead><tbody>"+
                            "<tr><td class='input-field'><input type='text' class='validate' id='id' name='reportParameter1'><label for='id'>Id</label></td></tr>"+
                            "<tr><td class='input-field'><input class='validate' id='bairro'  type='text' name='reportParameter2'><label for='bairro'>Bairro</label></td></tr>"+
                            "<tr><td class='input-field'><input type='text' class='validate' id='taxa' type='text' name='reportParameter3'><label for='taxa'>Taxa</label><input type='hidden' name='numParameter' value='3'></td></tr>";
                    break;
                case 'Produtos':
                    document.getElementById("reportParameter").innerHTML = "  <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead>"+
                            "<tbody><tr><td class='input-field'><input type='text' class='validate' id='id' name='reportParameter1'><label for='id'>Id</label></td></tr>"+
                        "<tbody><tr><td class='input-field'><input type='text' class='validate' id='nome' name='reportParameter2'><label for='nome'>Nome</label></td></tr>"+
                            "<tr><td class='input-field'><input class='validate' id='un' type='text' name='reportParameter3'><label for='un'>Unidade</label></td></tr>"+
                            "<td class='input-field'><input type='text' class='validate' id='valor' name='reportParameter4'><label for='valor'>Valor</label><input type='hidden' name='numParameter' value='4'></td></tr>";
                    break;
                case 'Formas de pgto' :
                    document.getElementById("reportParameter").innerHTML = "  <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead>"+
                            "<tbody><tr><td class='input-field'><input type='text' class='validate' id='id' name='reportParameter1'><label for='id'>Id</label></td></tr>"+
                            "<tr><td class='input-field'><input class='validate' id='forma'  type='text' name='reportParameter2'><label for='forma'>Forma</label><input type='hidden' name='numParameter' value='2'></td></tr>";
                    break;

                case 'Niveis':
                    document.getElementById("reportParameter").innerHTML = "  <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead>"+
                            "<tbody><tr><td class='input-field'><input type='text' class='validate' id='id' name='reportParameter1'><label for='id'>Id</label></td></tr>"+
                            "<tr><td class='input-field'><input class='validate' id='nome' type='text' name='reportParameter2'><label for='nome'>Nome</label><input type='hidden' name='numParameter' value='2'></td></tr>";
                    break;

                case 'Usuarios':
                    document.getElementById("reportParameter").innerHTML = "  <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead>"+
                             "<tbody><tr><td class='input-field'><input type='text' class='validate' id='usuario' name='reportParameter1'><label for='usuario'>Usuario</label></td></tr>"+
                             "<tr><td class='input-field'><input type='text' class='validate' id='login' name='reportParameter2'><label for='login'>Login</label></td></tr>"+
                            "<tr><td class='input-field'><input type='text' id='nome' name='reportParameter3'><label for='nome'>Nome</label><input type='hidden' name='numParameter' value='3'></td></tr>";
                    break;

                case 'Telefones':
                    document.getElementById("reportParameter").innerHTML = " <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead>"+
                            "<tbody><tr><td class='input-field'><input type='text' class='validate' id='nome' name='reportParameter1'><label for='nome'>Nome</label></td></tr>"+
                            "<tr><td class='input-field'><input type='text' name='reportParameter2'><label for='telefone'>Telefone</label><input type='hidden' name='numParameter' value='2'></td></tr>";
                    break;
                case 'Chamadas Recebidas':
                    document.getElementById("reportParameter").innerHTML = " <thead><tr><th>Parâmetro do relatòrio</th></tr><tr><th>Deixe em branco p/ completo</th><tr></thead><tbody><tr><td class='input-field'><input type='text' class='validate' id='nome'  name='reportParameter1'><label for='nome'>Nome</label></td></tr><tr><td class='input-field'><input type='text'></td></tr><tr><td>Unidade</td><td><input type='text'></td></tr><tr><td>Valor</td><td><input type='text'></td></tr>";
                    break;
                default:
                    break;
            }
        }
    </script>
</html>