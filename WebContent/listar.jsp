<%@page import="com.sixcodes.uploader.Listar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="margin-top:60px;">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="#" class="brand">Uploader v1.0</a>
			</div>
		</div>

	</div>
	<%@ page import="java.io.IOException"%>
	<%@ page import="java.io.PrintWriter"%>
	<%@ page import="java.sql.Connection"%>
	<%@ page import="java.sql.ResultSet"%>
	<%@ page import="java.sql.SQLException"%>
	<%@ page import="java.sql.Statement"%>

	<%@ page import="javax.servlet.ServletException"%>
	<%@ page import="javax.servlet.http.HttpServlet"%>
	<%@ page import="javax.servlet.http.HttpServletRequest"%>
	<%@ page import="javax.servlet.http.HttpServletResponse"%>

	<%@ page import="com.sixcodes.dao.Conectar"%>

	<%	
	
		Listar listar = new Listar();
		//PrintWriter out = response.getWriter();

		Connection connection = Conectar.getConnection();
		try {
			Statement st = connection.createStatement();
			ResultSet nm = st.executeQuery("SELECT * FROM arquivo");
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
			while (nm.next()) {
				out.println("<center>");
				out.println(" <tr>");
				out.println(" <td>" + "&nbsp" + nm.getString("nome")+ "&nbsp" + "</td>");
				out.println(" <td>"	+ "&nbsp"+ listar.convertToMb(Integer.valueOf(nm.getString("tamanho"))) + "&nbsp" + "</td>");
				out.println(" </tr>");
				out.println("</center>");
			}

			// finaliza a pagina
			out.println("</u1>");
			out.println(" </table>");
			out.println(" </html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	%>

</body>
</html>