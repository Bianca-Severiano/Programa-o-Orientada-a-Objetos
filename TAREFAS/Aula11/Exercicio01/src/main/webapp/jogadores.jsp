<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>Jogadores</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>

	<div style="text-align: center" class="container">
		<form action="jogadores" method="post">
			<p class="title" style="font-size: 50px;">
				<b>Jogador</b>
			</p>
			<table>
				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="1" id="idJogador" name="idJogador"
						placeholder="Código do Jogador"
						value='<c:out value="${jogador.id }"></c:out>'></td>
					<td><input type="submit" id="botao" name="botao"
						value="Buscar"></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="text"
						min="1" step="1" id="nomeJogador" name="nomeJogador"
						placeholder="Nome do Jogador"
						value='<c:out value="${jogador.nome }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="1"><label for="dataNascimento">Data de
							Nascimento:</label></td>
					<td colspan="1"><input class="id_input_data" type="date"
						id="nascJogador" name="nascJogador"
						value='<c:out value="${jogador.data_nasc }"></c:out>'></td>
				</tr>


				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="0.01" id="alturaJogador" name="alturaJogador"
						placeholder="Altura do jogador (m)"
						value='<c:out value="${jogador.altura }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="id_input_data" type="number"
						min="0" step="0.01" id="pesoJogador" name="pesoJogador"
						placeholder="Peso do jogador (kg)"
						value='<c:out value="${jogador.peso }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><select class="id_input_data" id="time"
						name="timeCodigo">
							<option value="0">Escolha um Time</option>
							<c:forEach var="t" items="${times }">
									test="${(empty times) || (t.codigo ne jogador.time.codigo) }">
									<option value="${t.codigo }">
										<c:out value="${t }" /></option>
							</c:forEach>
					</select></td>
				</tr>

				<td><input type="submit" id="botao" name="botao"
					value="Inserir"> <input type="submit" id="botao"
					name="botao" value="Alterar"> <input type="submit"
					id="botao" name="botao" value="Excluir"> <input
					type="submit" id="botao" name="botao" value="Consultar"></td>
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
		<c:if test="${not empty jogadores }">

			<table>
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Data de Nascimento</th>
						<th>Altura (m)</th>
						<th>Peso (Kg)</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="j" items="${jogadores}">
						<tr>
							<td style="text-align: center"><c:out value="${j.id }" /></td>
							<td style="text-align: center"><c:out value="${j.nome }" /></td>
							<td style="text-align: center"><c:out
									value="${j.data_nasc }" /></td>
							<td style="text-align: center"><c:out value="${j.altura}" /></td>
							<td style="text-align: center"><c:out value="${j.peso}" /></td>
							<td style="text-align: center"><c:out value="${j.time.nome}" /></td>
						</tr>
					</c:forEach>
				</tbody>
				</c:if>
			</table>
	</div>

</body>
</html>