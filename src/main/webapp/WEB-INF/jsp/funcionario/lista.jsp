<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Funcionarios</title>
</head>
<body>

	<a href="/funcionario/novo"> Novo Funcionario</a>
	<table>
		<thead>
			<tr>
				<th> Codigo </th>
				<th> Nome </th>
				<th> CPF </th>
				<th> Naturalidade </th>
				<th> Nome do Setor </th>
				<th> Quantidade de Funcionarios</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${funcionarios}" var="funcionario">
				<tr>
					<td><a href="/funcionario/visualizar/${funcionario.codigo}">${funcionario.codigo}</a></td>
					<td>${funcionario.nome}</td>
					<td>${funcionario.cpf}</td>
					<td>${funcionario.nomeSetor}</td>
					<td>${funcionario.quantidadeFuncionarios}</td>
					<td>${funcionario.naturalidade.nome}</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>