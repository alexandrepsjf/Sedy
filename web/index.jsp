<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
    <title>Tela de pesquisa</title>
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
    <style>

    </style>
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
                    <i class="large teal-text material-icons shadowOrange tooltipped  " data-position="bottom" data-delay="50"
                       data-tooltip="RELATÓRIOS">print</i>
                </a>
            </li> 
           <li>

                <a class=" waves-effect" onclick="self.close ()">
                    <i class="large teal-text material-icons shadowOrange tooltipped" data-position="bottom" data-delay="50"
                       data-tooltip="SAIR">room</i>
                </a>
            </li>
        </ul>
        <ul class="side-nav" id="mobile-demo">

        </ul>
    </div>

</nav>
<h4 class=" teal-text shadowOrange center">Sistema de entregas delivery</h4>
<div class="left icones">

    <a href="PesquisaClienteController" class=" waves-effect">
        <i class="large teal-text material-icons icone tooltipped" data-position="bottom" data-delay="50"
           data-tooltip="CLIENTES">face</i>
    </a>
    <a href="PesquisaTelefoneController">
        <i class="large teal-text lighten-3 material-icons icone tooltipped" data-position="bottom" data-delay="50"
           data-tooltip="TELEFONE">phone</i>
    </a>
    <a href="PesquisaBairroController">
        <i class="large teal-text material-icons icone tooltipped" data-position="bottom" data-delay="50"
           data-tooltip="BAIRROS">satellite</i>
    </a>
    </a>
    <a href="PesquisaLigacaoController">
        <i class="large teal-text material-icons icone tooltipped" data-position="bottom" data-delay="50"
           data-tooltip="LIGAÇÕES">contact_phone</i>
    </a>
    <a href="PesquisaEmailController">
        <i class="large teal-text material-icons icone tooltipped" data-position="bottom" data-delay="50"
           data-tooltip="EMAILS">mail</i>
    </a>
    <a href="PesquisaUsuarioController">
        <i class="large teal-text material-icons icone tooltipped" data-position="top" data-delay="50"
           data-tooltip="USUÁRIOS">assignment_ind</i>
    </a>
    <a href="PesquisaNivelController">
        <i class="large teal-text material-icons icone tooltipped" data-position="top" data-delay="50"
           data-tooltip="NIVEL">supervisor_account</i>
    </a>
    <a href="PesquisaProdutoController">
        <i class="large teal-text material-icons icone tooltipped" data-position="top" data-delay="50"
           data-tooltip="PRODUTOS">shop</i>
    </a>
    <a href="PesquisaFormaPagamentoController">
        <i class="large teal-text material-icons icone tooltipped" data-position="top" data-delay="50"
           data-tooltip="FORMAS DE PAGAMENTO">credit_card</i>
    </a>

    <a href="PesquisaPedidoController">
        <i class="large teal-text material-icons icone tooltipped" data-position="top" data-delay="50"
           data-tooltip="PEDIDOS">shopping_cart</i>
    </a>


</div>

</body>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<!--js extra-->
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript">
</script>
</html>