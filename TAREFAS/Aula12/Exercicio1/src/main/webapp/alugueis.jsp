<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alugueis</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div style="text-align: center" class="container">
		<form action="alugueis" method="post">
			<p class="title" style="font-size: 50px;">
				<b>Aluguel</b>
			</p>
			<table>
			
			<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="1" id="codigoExemplar" name="codigoExemplar"
						placeholder="Código do Exemplar"
						value='<c:out value="${aluguel.getExemplar().codigo }"></c:out>'></td>
					<td><input type="submit" id="botao" name="botao"
						value="Buscar"></td>
					<td colspan="4"><h3>
							<c:out value="${aluguel.getExemplar().nome }" ></c:out>
						</h3></td>

				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="1" id="raAluno" name="raAluno"
						placeholder="RA do Aluno"
						value='<c:out value="${aluguel.getAluno().RA }"></c:out>' readonly></td>
					
					<td colspan="4">
						<h3>
							<c:out value="${aluguel.getAluno().nome }"></c:out>
						</h3>
					</td>
				</tr>



				<tr>
					<td colspan="1"><label for="dataRetirada">Data de
							Retirada:</label></td>
					<td colspan="1"><input class="id_input_data" type="date"
						id="dataRetirada" name="dataRetirada"
						value='<c:out value="${aluguel.dataRetirada }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="1"><label for="dataDevolucao">Data de
							Devolução:</label></td>
					<td colspan="1"><input class="id_input_data" type="date"
						id="dataDevolucao" name="dataDevolucao"
						value='<c:out value="${aluguel.dataDevolucao }"></c:out>'></td>
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
		<c:if test="${not empty alugueis }">

			<table>
				<thead>
					<tr>
						<th>Data retirada</th>
						<th>Data devolução</th>
						<th>Aluno</th>
						<th>RA</th>
						<th>E-mail</th>
						<th>Código do Exemplar</th>
						<th>Nome do Livro</th>
						<th>Páginas</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${alugueis }">
						<tr>
							<td style="text-align: center"><c:out value="${a.dataRetirada }" /></td>
							<td style="text-align: center"><c:out value="${a.dataDevolucao }" /></td>
							<td style="text-align: center"><c:out value="${a.getAluno().nome }" /></td>
							<td style="text-align: center"><c:out value="${a.getAluno().RA }" /></td>
							<td style="text-align: center"><c:out value="${a.getAluno().email }" /></td>
							<td style="text-align: center"><c:out value="${a.getExemplar().codigo }" /></td>
							<td style="text-align: center"><c:out value="${a.getExemplar().nome }" /></td>
							<td style="text-align: center"><c:out value="${a.getExemplar().qtdPaginas }" /></td>
						</tr>
					</c:forEach>
				</tbody>
				</c:if>
			</table>
	</div>
</body>
</html>