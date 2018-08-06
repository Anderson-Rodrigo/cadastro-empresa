<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<label for="nome"> Nome </label>
<input type="text" name="nome" id="nome" value="${funcionario.nome}">
<form:errors path="funcionario.nome"/>
<label for="cpf"> CPF </label>
<input type="text" name="cpf" id="cpf" value="${funcionario.cpf}">
<form:errors path="funcionario.cpf"/>

<label for="nomeSetor"> Nome do Setor </label>
<input type="text" name="nomeRua" id="nomeRua" value="${setor.nomeSetor}">
<label for="quantidadeFuncionarios"> Quantidade de Funcionarios </label>
<input type="text" name="numero" id="numero" value="${setor.quantidadeFuncionarios}">

<label for="naturalidade"> Naturalidade </label>
<select name="naturalidade.codigo">


	<option></option>
	<c:forEach items="${empresa}" var="cidade">
		<c:set var="selecionado" value=""/>
		<c:if test="${empresa.codigo eq funcionario.naturalidade.codigo}">
			<c:set var="selecionado" value="selected"/>
		</c:if>	
			<option value="${empresa.codigo}"${selecionado}>${empresa.nome}</option>
	</c:forEach>
</select>

