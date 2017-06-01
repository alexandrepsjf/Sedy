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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/css.css">
    </head>
    <body class="search">
        <div class="title"><h1>Pesquisa de Bairros</h1></div>
        <div class="footer"> 
            &#9668; <a href="ManterInicio"><button>inicio</button></a>    
        </div>       
        <div class="logoSearch">            
        </div>
        <table  class="table">            
            <tr> 
                <th>Código Bairro</th>
                <th>Nome Bairro</th>
                <th colspan="2">Ação</th>                
            </tr>
            <c:forEach items="${bairros}" var="bairro">
                <tr>
                    <td ><c:out value="${bairro.id}" /> </td>
                    <td ><c:out value="${bairro.nome}" /> </td>
                    <td ><a href="ManterBairroController?acao=prepararEditar&id=<c:out value="${bairro.id}"/>">Editar</a></td>
                    <td ><a href="ManterBairroController?acao=prepararExcluir&id=<c:out value="${bairro.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>         
        <div class="footer">  

            <form  action="ManterBairroController?acao=prepararIncluir" method="POST">             
                <input  type="submit" name="btnIncluir" value="Incluir">
            </form>

        </div>

    </body>
</html>
