<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src=".../jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src=".../jquery.validate.min.js"></script>
	<script type="text/javascript"	src="<c:url value="/javascripts/jquery-1.3.2.min.js"/>"></script>
	<script type="text/javascript"	src="<c:url value="/javascripts/jquery.validate.min.js"/>"></script>
	<script type="text/javascript"	src="<c:url value="/javascripts/jquery.autocomplete.min.js"/>"></script>
	<script type="text/javascript"	src="<c:url value="/javascripts/jquery.puts.js"/>"></script>

<title>Formulário</title>
</head>
<body>

	<form id="produtosForm" action="<c:url value="/produtos"/>"
		method="POST">
		<fieldset>
			<legend>Adicionar Produto</legend>

			<label for="nome">Nome:</label> 
			<input id="nome" type="text" name="produto.nome" value="${produto.id }" />
			
			<br> 
			
			<label for="descricao">Descrição:</label>
			<textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea>
			
			<br> 
			
			<label for="preco">Preco:</label>
			<input id="preco" type="text" name="produto.preco" value="${produto.preco }" />
			
			<br>
			
			<button class="link" type="submit">Enviar</button>
		</fieldset>

	<script type="text/javascript">
		$('#produtosForm').validate({
			rules: {
				"produto.nome": {
					required: true,
					minlength: 3
				},
				"produto.descricao": {
					required: true,
					maxlength: 40
				},
				"produto.preco": {
					required: true,
					min: 0.0
				}
			}
		});	
	</script>

	</form>
</body>
</html>