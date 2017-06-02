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
        <title>Pesquisa de Bairros</title>
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
        <link rel="stylesheet" href="css.css">

    </head>

    <body class="">
        <nav class="nav-extended teal lighten-3">
            <div class="nav-wrapper">
                <a href="ManterInicio" class=" brand-logo center mylogo shadowOrange blue-text tooltipped" data-position="bottom" data-delay="50"
                   data-tooltip="HOME">SEDY</a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li>
                        <a href="PesquisaRelatorioController">
                            <i class="large teal-text material-icons shadowOrange tooltipped  " data-position="bottom"
                               data-delay="50"
                               data-tooltip="RELATÓRIOS">print</i>
                        </a>
                    </li>
                    <li>

                        <a class=" waves-effect">
                            <i class="large teal-text material-icons shadowOrange tooltipped" data-position="bottom"
                               data-delay="50"
                               data-tooltip="SAIR">room</i>
                        </a>
                    </li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                </ul>
            </div>
        </nav>
        <h4 class=" teal-text shadowOrange center">Sistema de entregas delivery</h4>
        <div class="center "><h3>Pesquisa de Bairros</h3></div>


        <table class=" highlight centered">
            <thead>  </div>
                <tr>
                    <th>Código Bairro</th>
                    <th>Nome Bairro</th>
                    <th class="col l2">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${bairros}" var="bairro">
                    <tr>
                        <td><c:out value="${bairro.id}"/></td>
                        <td><c:out value="${bairro.nome}"/></td>
                        <td><a href="ManterBairroController?acao=prepararEditar&id=<c:out value='${bairro.id}'/>">Editar</a></td>
                        <td><a href="ManterBairroController?acao=prepararExcluir&id=<c:out value='${bairro.id}'/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="">
            <form action="ManterBairroController?acao=prepararIncluir" method="POST">

                <div class="input-field col s12 btn waves-effect waves-light">
                    <input id="submit" type="submit" class="submit" name="btnIncluir" value="Incluir">                 
                    <i class="material-icons right">send</i>
                </div>
            </form>
        </div>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <!--js extra-->
        <script type="text/javascript" src="js/app.js"></script>
        <script type="text/javascript"></script>
    </body>
</html>