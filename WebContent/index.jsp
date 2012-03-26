<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uploader by JesueJunior</title>
</head>
<body style="margin-top:60px;">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="#" class="brand">Uploader v1.0</a>
			</div>
		</div>

	</div>
	<div class="container">
		<form class="well" action="Upload" enctype="multipart/form-data"
			method="post">
			<input class="span3" type="file" name="Selecione o arquivo"><br>
			<input class="btn btn-success" type="submit" value="Upload">&nbsp;
			<a href="listar.jsp" class="btn btn-primary pull-right">Listar arquivos</a>
		</form>
	</div>
</body>
</html>