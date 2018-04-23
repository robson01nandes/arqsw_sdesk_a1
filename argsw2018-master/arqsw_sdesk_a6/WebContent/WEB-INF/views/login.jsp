<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Login</h3>
        <form action="login" method="post">
        	<span style="color:red">${msg}</span>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="fila">Usuario:</label>
                    <input class="form-control" placeholder="Usuario" name="username"/>
                    <form:errors path="usuario.username" cssStyle="color:red"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="fila">Senha:</label>
                    <input class="form-control" placeholder="Senha" name="password"/>
                    <form:errors path="usuario.password" cssStyle="color:red"/>
                </div>
            </div>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary">Entrar</button>
                    <button type="reset" class="btn">Cancelar</button>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>