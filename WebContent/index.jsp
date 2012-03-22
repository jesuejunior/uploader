<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uploader by JesueJunior</title>
</head>
<body>

<div class="container">
<form class="well" action="Upload" enctype="multipart/form-data" method="post">
	<center>
		<header>
			<h3>Uploader v 0.1</h3>
		</header>

		<input class ="span3" type="file" name="Selecione o arquivo"><br> 
		<input class="btn btn-success" type="submit" value="Upload">&nbsp;
	</center>
</form>

<center>
	<a href="Listar" class="btn btn-primary">Listar arquivos</a>
</center>
</div>

</body>
</html>