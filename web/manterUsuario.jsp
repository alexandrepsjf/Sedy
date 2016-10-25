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
        <title>Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Usuario -  ${operacao}</h1></div>
        <form action="ManterBairroController?acao=confirmar${operacao}" method="POST" name="frmManterBairro" >
        <table>            
            <tr> 
                <td colspan="2"> Cod. usuario </td><td><input type="text" size="15" name="id" value="${usuario.id}"></td>
            </tr>
            <tr> 
            <tr> 
                <td colspan="2"> Nivel usuario </td>
                <td>
                    <select><option>Gerente</option><option></option><option></option><option></option></select></td>
            </tr>
            <tr> 
                <td colspan="2"> Nome usuario </td><td><input type="text" size="40" name="nome" value="${usuario.nome}"></td>
            </tr>
            <tr> 
                <td colspan="2"> senha usuario </td><td><input type="text" size="15"  ></td>
            </tr>
            <tr> 
                <td colspan="2"> confirma senha usuario </td><td><input type="text" size="15" name="senha" value="${usuario.senha}"></td>
            </tr>

        </table>
        </form>
        <h3><button>Cadastrar nivel</button></h3>
        <h3><button>Confirmar</button></h3>
    </body>
</html>
