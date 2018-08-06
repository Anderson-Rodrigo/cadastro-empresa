<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Funcionario</title>
</head>
<body>

	<form action="/funcionario/alterar" method="post">
		
		<input type="hidden" name="codigo" value="${funcionario.codigo}">	
		<c:import url="_campos.jsp"/>
		
		<button type="submit">Salvar</button>
		<a href="/funcionario/listar">Cancelar</a>
		<a href="/funcionario/deletar/${funcionario.codigo}">Deletar</a>
		
	</form>
</body>
</html>