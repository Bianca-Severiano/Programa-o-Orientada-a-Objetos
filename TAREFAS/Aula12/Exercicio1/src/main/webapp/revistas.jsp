<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Revistas</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div style="text-align: center" class="container">
		<form action="revistas" method="post">
			<p class="title" style="font-size: 50px;">
				<b>Revista</b>
			</p>
			<table>
				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="1" id="codigoRevista" name="codigoRevista"
						placeholder="Código do Exemplar"
						value='<c:out value="${revista.getCodigo() }"></c:out>'></td>
					<td><input type="submit" id="botao" name="botao"
						value="Buscar"></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="nomeRevista" name="nomeRevista"
						placeholder="Nome do Exemplar"
						value='<c:out value="${revista.getNome() }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="0.01" id="qtdPaginasRevista" name="qtdPaginasRevista"
						placeholder="Número de Páginas"
						value='<c:out value="${revista.getQtdPaginas() }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="ISSNRevista" name="ISSNRevista"
						placeholder="ISSN"
						value='<c:out value="${revista.ISSN }"></c:out>'></td>
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
		<c:if test="${not empty revistas }">

			<table>
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
                        <th>Quantidade de Páginas</th>
                        <th>ISSN</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${revistas}">
						<tr>
							<td style="text-align: center"><c:out value="${r.getCodigo() }" /></td>
							<td style="text-align: center"><c:out value="${r.getNome() }" /></td>
							<td style="text-align: center"><c:out value="${r.getQtdPaginas() }" /></td>
							<td style="text-align: center"><c:out value="${r.ISSN}" /></td>
						</tr>
					</c:forEach>
				</tbody>
				</c:if>
			</table>
	</div>

</body>
</html>