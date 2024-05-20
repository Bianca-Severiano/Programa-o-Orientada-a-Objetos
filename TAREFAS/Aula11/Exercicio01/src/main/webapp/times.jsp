<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>Times</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div style="text-align: center" class="container">
		<form action="times" method="post">
			<p class="title" style="font-size: 50px;">
				<b>Time</b>
			</p>
			<table>
				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="1" id="idTime" name="idTime"
						placeholder="Código do Time"
						value='<c:out value="${time.codigo }"></c:out>'></td>
					<td><input type="submit" id="botao" name="botao"
						value="Buscar"></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="nomeTime" name="nomeTime"
						placeholder="Nome do Time"
						value='<c:out value="${time.nome }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="cidadeTime" name="cidadeTime"
						placeholder="Cidade do Time"
						value='<c:out value="${time.cidade }"></c:out>'></td>
				</tr>

				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Inserir"> <input type="submit" id="botao"
						name="botao" value="Alterar"> <input type="submit"
						id="botao" name="botao" value="Excluir"> <input
						type="submit" id="botao" name="botao" value="Consultar"></td>
				</tr>

			</table>
		</form>
	</div>

	<br>

	<div style="text-align: center">
		<c:if test="${not empty erro}">
			<h2>
				<b><c:out value="${erro }" /></b>
			</h2>
		</c:if>
	</div>

	<div style="text-align: center">
		<c:if test="${not empty saida }">
			<h3>
				<b><c:out value="${saida }" /></b>
			</h3>
		</c:if>
	</div>

	<div style="text-align: center">
		<c:if test="${not empty times }">

			<table>
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Cidade</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${times}">
						<tr>
							<td style="text-align: center"><c:out value="${t.codigo }" /></td>
							<td style="text-align: center"><c:out value="${t.nome }" /></td>
							<td style="text-align: center"><c:out value="${t.cidade }" /></td>
						</tr>
					</c:forEach>
				</tbody>
		</c:if>
		</table>
	</div>
</body>
</html>