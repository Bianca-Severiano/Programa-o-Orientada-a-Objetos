<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Calcule o seu Imposto</title>
</head>
<body>

	
	<h1>Qual seu estado?</h1>

	<div class="bloco">
	<div id="botoes">
	<button id="BH" name="btn" value="BH" type="submit" onClick="window.location.href='http://localhost:8080/Exercicio1/BeloHorizonte.jsp'">Belo Horizonte</button>
		<button id="SP" name="btn" value="SP" type="submit" onclick="window.location.href='http://localhost:8080/Exercicio1/SaoPaulo.jsp'">São Paulo</button>
		<button id="PA" name="btn" value="PA" type="submit" onClick="window.location.href='http://localhost:8080/Exercicio1/PortoAlegre.jsp'">Porto Alegre</button>
		<button id="CB" name="btn" value="CB" type="submit" onclick="window.location.href='http://localhost:8080/Exercicio1/Curitiba.jsp'">Curitiba</button>
	</div>
	</div>

</body>
</html>