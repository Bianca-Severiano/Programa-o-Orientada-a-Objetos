<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/pages.css">
<title>Belo Horizonte</title>
</head>
<body>

<h1>BELO HORIZONTE</h1>


<div class="bloco">
<form action="belohorizonte" method="post">
<table>
		<tr>
		<td>
			<input type="text" name="Valor_Area_BH" size="30"  id="Valor_Area_BH" placeholder="Área"> 
			<input type="text" name="Num_Quartos_BH" size="30"  id="Num_Quartos_BH" placeholder="Número de Quartos"> 
			<button id="calcularBH" value="calcularBH" name="btn" type="submit">Calcular</button>
		</td>
	</tr>
</table>
</form>

<button id="CB" name="btn" value="CB" type="submit" onclick="window.location.href='http://localhost:8080/Exercicio1/index.jsp'">Voltar</button>
</div>
<br>
<br>

	<c:if test="${not empty saida}">
		<div style="color: green; display: flex; justify-content: center">
		<c:out value="${saida}"></c:out>
		</div>
	</c:if>
</body>
</html>