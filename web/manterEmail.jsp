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
        <title>Email</title>
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
    <body onLoad="checkbox()">
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
        <div class="container center  ">
            <h3>Email - ${operacao}</h3>
            <div class="row ">
                <form action="ManterEmailController?acao=confirmar${operacao}" method="post" name="frmManterEmail" onsubmit="return validarFormulario(this)" >
                    <div class="row ">
                        <div class='input-field col l6 push-l3'> <input type="text" class='validate ' name="id" id="id" value="${email.id}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><label for='id'>Id</label>
                            </div>
                        </div>

                        <div class="row ">
                            <div class='input-field col l6 push-l3'> <input type="text" class='validate'name="email" id="email" value="${email.email}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><label for='email'>email</label>
                            </div> 
                        </div>
                        <div class="row ">
                            <div class='input-field col l6 push-l3'> <input type="text" class='validate' name="senha" id="senha" value="${email.senha}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><label for='senha'>Senha</label>
                            </div>
                        </div>
                        <div class="row  ">
                            <div class='input-field col l6 push-l3'> <input type="text" class='validate' name="autentica" id="autentica" value="${email.autentica}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><label for='autentica'>Autenticação</label>
                            </div>
                        </div>
                        <div class="row   ">
                            <div class='input-field col l6 push-l3'> <input type="text" class='validate' name="servidorSaida" id="servidorSaida" value="${email.servidorSaida}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><label for='servidorSaida'>Servidor de saída</label>
                        </div> 
                    </div>

                    <div class=" row  col l2 push-l5 btn waves-effect waves-light">
                        <input id="submit" type="submit" class="submit" name="btnIncluir" value="Incluir">                 
                        <i class="material-icons right">send</i>
                    </div>
                </form>
            </div>
        </div>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <!--js extra-->
        <script type="text/javascript" src="js/app.js"></script>
        <script type="text/javascript"></script>
        <SCRIPT language="JavaScript">


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
                        if (form.id.value == "") {
                            mensagem = mensagem + "Informe o Código do email\n";
                        }

                        if (!campoNumerico(form.id.value)) {
                            mensagem = mensagem + "Código do Email deve ser numérico\n";
                        }

                        if (mensagem == "") {
                            return true;
                        } else {
                            alert(mensagem);
                            return false;
                        }

                    }

        </SCRIPT>            
    </body>
</html>
