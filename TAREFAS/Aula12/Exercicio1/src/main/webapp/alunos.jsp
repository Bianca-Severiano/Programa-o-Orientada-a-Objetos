<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alunos</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div style="text-align: center" class="container">
		<form action="alunos" method="post">
			<p class="title" style="font-size: 50px;">
				<b>Alunos</b>
			</p>
			<table>
				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="1" id="raAluno" name="raAluno"
						placeholder="RA"
						value='<c:out value="${aluno.RA }"></c:out>'></td>
					<td><input type="submit" id="botao" name="botao"
						value="Buscar"></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="nomeAluno" name="nomeAluno"
						placeholder="Nome do Aluno"
						value='<c:out value="${aluno.nome }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="emailAluno" name="emailAluno"
						placeholder="E-mail"
						value='<c:out value="${aluno.email }"></c:out>'></td>
				</tr>

				<td><input type="submit" id="botao" name="botao"
					value="Inserir"> <input type="submit" id="botao"
					name="botao" value="Alterar"> <input type="submit"
					id="botao" name="botao" value="Excluir"> <input
					type="submit" id="botao" name="botao" value="Listar"></td>
				<tr>
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
		<c:if test="${not empty alunos }">

			<table>
				<thead>
					<tr>
						<th>RA</th>
						<th>Nome</th>
                        <th>E-mail</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${alunos}">
						<tr>
							<td style="text-align: center"><c:out value="${a.RA }" /></td>
							<td style="text-align: center"><c:out value="${a.nome }" /></td>
							<td style="text-align: center"><c:out value="${a.email }" /></td>
						</tr>
					</c:forEach>
				</tbody>
				</c:if>
			</table>
	</div>
</body>
</html>