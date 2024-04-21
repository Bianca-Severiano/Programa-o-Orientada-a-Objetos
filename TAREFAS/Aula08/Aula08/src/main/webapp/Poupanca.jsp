<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta Poupança</title>
</head>
<body>
	<h1 style="color: green; display: flex; justify-content: center">Conta Poupança</h1>
	
	<div style="display: flex; flex-direction: row; justify-content: center; align-items: center;">
	
	<form action="poupanca" method = "post">
	<table>
	<tr>
		<td>
			<input type="text" name="valorDeposito" size="30"  id="valorDeposito" placeholder="Valor para Deposito"> 
			<button id="deposito" value="Deposito" name="btn" type="submit">Depósito</button>
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="valorSaque" size="30"  id="Valor_Saque" placeholder="Valor para Saque"> 
			<button id="saque" value="Saque" name="btn" type="submit">Saque</button>
		</td>
	</tr>
		<tr>
		<td>
			<input type="text" name="valorRendimento" size="30"  id="Valor_Rendimento" placeholder="Valor de Rendimento"> 
			<button id="dCliente" value="Rendimento" name="btn" type="submit">Rendimento</button>
		</td>
	</tr>
	<tr>
		<td>
			<button id="dCliente" value="Dados" name="btn" type="submit">Dados do Cliente</button>
			
		</td>
	</tr>
	</table>
	</form>
	</div>
	
	<br>
	<br>
	
	<c:if test="${ not empty saida}">
		<div style="color: green; display: flex; justify-content: center">
		<c:out value="${saida}"></c:out>
		</div>
	</c:if>
	
</body>
</html>