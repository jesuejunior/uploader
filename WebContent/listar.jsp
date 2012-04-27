<%@page import="java.io.FileOutputStream"%>
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
				<a href="index.jsp" class="brand">Uploader v1.0</a>
			</div>
		</div>

	</div>

	<%@ page import="java.util.List"%>
	<%@ page import="org.apache.commons.fileupload.FileItem"%>
	<%@ page import="java.lang.Exception"%>
	<%@ page import="java.io.File"%>
	<%@page import="com.sixcodes.uploader.Upload"%>
	<%@ page import="com.sixcodes.dao.HibernateUtil"%>
	<%@ page import="com.sixcodes.uploader.Arquivo"%>
	<%@ page import="com.sixcodes.uploader.Convert"%>

	<%	
	
		Arquivo arquivo = new Arquivo();
		Convert convert = new Convert();
		Upload upload = new Upload();

		try {
			List<Arquivo> arquivos = HibernateUtil.listarTodos(new Arquivo());
			out.println(" <html>");
			out.println("<u1 class=\"nav nav-tabs nav-stacked\">");
			out.println(" <center><h2> Lista de arquivos </h2>");
			out.println(" <table border=1>");
			out.println(" <tr>");
			out.println(" <td><center><b>Nome</b></center></td>");
			out.println(" <td><center><b>Tamanho</b></center></td>");
			out.println(" </tr>");
			out.println("</center>");

			// Mostra o nome e tamanho do arquivo
			for(Arquivo a : arquivos) {
				out.println("<center>");
				out.println(" <tr>");
				out.println(" <td>" + "&nbsp" + a.getNome() + "&nbsp" + "</td>");
				out.println(" <td>"	+ "&nbsp"+ convert.convertToMb(a.getTamanho()) + "&nbsp" + "</td>");
				out.println(" <td>" + "&nbsp" + "<a href= " + "'" + a.getCaminho()+  "'" + "&nbsp" + "class=\"btn btn-primary pull-right\">Download</a>" + "</td>");
				out.println(" </tr>");
				out.println("</center>");
			}

			// finaliza a pagina
			out.println("</u1>");
			out.println(" </table>");
			out.println(" </html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	%>
</body>
</html>