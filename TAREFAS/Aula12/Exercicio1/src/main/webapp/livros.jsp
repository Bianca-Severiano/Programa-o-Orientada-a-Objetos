<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Livros</title>
</head>
<body>
<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div style="text-align: center" class="container">
		<form action="livros" method="post">
			<p class="title" style="font-size: 50px;">
				<b>Livro</b>
			</p>
			<table>
				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="1" id="codigoLivro" name="codigoLivro"
						placeholder="Código do Exemplar"
						value='<c:out value="${livro.getCodigo() }"></c:out>'></td>
					<td><input type="submit" id="botao" name="botao"
						value="Buscar"></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="nomeLivro" name="nomeLivro"
						placeholder="Nome do Exemplar"
						value='<c:out value="${livro.getNome() }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="0.01" id="qtdPaginasLivro" name="qtdPaginasLivro"
						placeholder="Número de Páginas"
						value='<c:out value="${livro.getQtdPaginas() }"></c:out>'></td>
				</tr>

                <tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="0.01" id="edicaoLivro" name="edicaoLivro"
						placeholder="Número da Edição"
						value='<c:out value="${livro.edicao }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="ISBNLivro" name="ISBNLivro"
						placeholder="ISBN"
						value='<c:out value="${livro.ISBN }"></c:out>'></td>
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
		<c:if test="${not empty livros }">

			<table>
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
                        <th>Edição</th>
                        <th>Quantidade de Páginas</th>
                        <th>ISBN</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${livros}">
						<tr>
							<td style="text-align: center"><c:out value="${l.getCodigo() }" /></td>
							<td style="text-align: center"><c:out value="${l.getNome() }" /></td>
                            <td style="text-align: center"><c:out value="${l.edicao }" /></td>
							<td style="text-align: center"><c:out value="${l.getQtdPaginas() }" /></td>
							<td style="text-align: center"><c:out value="${l.ISBN}" /></td>
						</tr>
					</c:forEach>
				</tbody>
				</c:if>
			</table>
	</div>

</body>
</html>