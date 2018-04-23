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
    <title>Listar filas</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Filas</h3>
        <c:if test="${not empty filas }">
	        <table class="table">
	        	<thead>
	        		<tr>
	        			<th></th>
	        			<th>Nome</th>
	        			<th>Ação</th>
	        		</tr>
	        	</thead>
	        	<tbody>
	        		<c:forEach items="${filas }" var="f">
	        			<tr>
	        				<td><img alt="?" src="img/${f.caminhoFigura}"  height="48" width="48" class="img-circle"></td>
	        				<td>${f.nome }</td>
	        				<td><a href="<c:url value='/fila-exibir?id=${f.id }'/>">Exibir</a></td>
	        			</tr>
	        		</c:forEach>
	        	</tbody>	
	        </table>
        </c:if>
        <c:if test="${empty filas }">
        	<h4>Nenhuma fila encontrado</h4>
        </c:if>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>