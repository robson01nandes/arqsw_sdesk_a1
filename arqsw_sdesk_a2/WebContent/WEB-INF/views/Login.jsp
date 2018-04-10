<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		<!-- Barra superior com os menus de navegação -->
	    <c:import url="Menu.jsp" />
	    <!-- Container Principal -->
	    <div id="main" class="container">
	    	<h3 class="page-header">Login</h3>
    		<c:if test="${usuarioLogado eq 'Invalido'}">
    			<div class="row">
    				<div class="col-md-4">
		    			<p style="padding: 15px;" class="bg-info">Usuário ou Senha inválidos!</p>
		    		</div>
		    	</div>
    		</c:if>
	    	<form action="fazer_login" method="post">
	    		<div class="row">
	                <div class="form-group col-md-4">
	                    <label for="username">Digite o usuário:</label>
	                    <form:errors path="login.username" cssStyle="color:red"/><br>
	                    <input type="text" class="form-control" name=username maxlength="50">
	                </div>
	            </div>
	            <div class="row">
	                <div class="form-group col-md-4">
	                    <label for="username">Digite a senha:</label>
	                    <form:errors path="login.password" cssStyle="color:red"/><br>
	                    <input type="password" class="form-control" name=password maxlength="50">
	                </div>
	            </div>
	            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" >Logar</button>
                </div>
            </div>
	    	</form>
	    </div>
	    <script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>