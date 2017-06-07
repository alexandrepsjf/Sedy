
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@page contentType="text/html" pageEncoding="utf-8"%> 
<!DOCTYPE html>
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
        <div class="center "><h3>Nivel - ${operacao}</h3></div>
        
        <form action="ManterNivelController?acao=confirmar${operacao}" method="post" name="frmManterNivel" onsubmit="return validarFormulario(this)">
            <table class=" highlight centered">            
                <tr>
                    <td> COD. NÍVEL </td><td><input type="text"  name="id" value="${nivel.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td > NOME DO NÍVEL</td><td><input type="text"   name="nome"  value="${nivel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" id="1" name="nivel" value="${nivel.nivel}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if> >NIVEL</td>
                    <td> <input type="checkbox" id="2" name="relatorio" value="${nivel.relatorio}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>RELATORIO</td>
                    <td><input checked   type="checkbox" id="3" name="ligacaoRecebida" value="${nivel.ligacaoRecebida}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>LIGACAO RECEBIDA</td>
                    </tr>
                    <tr> 
                        <td><input type="checkbox" id="4" name="configuracao" value="${nivel.configuracao}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>CONFIGURACAO</td>
                    <td> <input type="checkbox" id="5" name="usuario" value="${nivel.usuario}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>USUARIO</td>
                    <td><input checked   type="checkbox" id="6" name="pedido" value="${nivel.pedido}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>PEDIDO</td>
                    </tr>
                    <tr><td><input  type="checkbox" name="produto" id="7" value="${nivel.produto}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>PRODUTOS</td>
                    <td> <input c type="checkbox" name="formaPagamento" id="8" value="${nivel.forma_pgm}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>FORMAS DE PAGTO</td>
                    <td><input checked   type="checkbox" name="cliente" id="9" value="${nivel.cliente}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>CLIENTES</td>
                </tr>
            </table>
            <div class="footer">
                <button  type="submit" >Confirmar</button>
            </div>
        </form>
        <div class="logoSearch">            
        </div>        </form>
    <SCRIPT language="JavaScript">

        function checkbox() {
            for (x = 1; x <= 9; x++) {
                var valor = document.getElementById(x);
                alert(valor.value);
                if (valor.value) {
                    alert("entrei");
                    valor.checked = true;
                }
            }
        }
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
                mensagem = mensagem + "Informe o Código do Nivel\n";
            }

            if (!campoNumerico(form.id.value)) {
                mensagem = mensagem + "Código do Nivel deve ser numérico\n";
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
