<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contratar Engenheiro</title>
</head>
<body>

<h1>Alteração Dados Aluno</h1>
	
	<form action="chamadaservlet" method="post">
		Cnpj <input type="text" name="txtra" value="${aluno.ra }" readonly><br><br>
		Status: <input type="hidden" name="txtnome" value="${aluno.nome }" ><br><br>
		Nome Engenheiro: <input type="hidden" name="txtpri" value="${aluno.prim }" ><br><br>
		<input type="hidden" name="acao" value="contratar">
		<input type="submit" value="Contratar">
	</form>
	

</body>
</html>