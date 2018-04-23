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
    <title>Criar Fila</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Criar Fila</h3>
        <form action="fila" method="post" enctype="multipart/form-data">
            <input name="id" type="hidden" value="${fila.id }">
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="fila">Nome:</label>
                    <form:errors path="fila.nome" cssStyle="color:red"/><br>
                    <input value="${fila.nome}" class="form-control" placeholder="Descrição" name="nome"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="fila">Imagem:</label>
                    <input type="file" class="form-control" placeholder="Descrição" name="file"/>
                </div>
            </div>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary">Salvar</button>
                    <a href="index" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>