package com.sixcodes.uploader;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixcodes.dao.Conectar;

/**
 * Servlet implementation class Listar
 */
public class Listar extends HttpServlet {
	private static final int KB = 1024;
	private static final int MB = KB*KB;
	private static final int GB = MB*KB;
	private static final long serialVersionUID = 1L;
	Upload listaUpload = new Upload();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Listar() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String convertToMb(int bytes) {
		if (bytes < KB) {
			return Integer.toString(bytes)+ " bytes";
		} else if(bytes < GB){
			return Integer.toString(bytes / MB) + " Mb";
		}else{
			return Integer.toString(bytes / GB) + " Gb";
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Connection connection = Conectar.getConnection();
		try {
			Statement st = connection.createStatement();
			ResultSet nm = st.executeQuery("SELECT * FROM arquivo");
			out.println(" <html>");
			out.println(" <center><h2> Listagem de arquivo </h2>");
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
				out.println(" <td>" + "&nbsp" + nm.getString("nome") + "&nbsp" + "</td>");
				out.println(" <td>"	+ "&nbsp" + this.convertToMb(Integer.valueOf(nm.getString("tamanho"))) + "&nbsp" + "</td>");
				out.println(" </tr>");
				out.println("</center>");
			}

			// finaliza a pagina
			out.println(" </table>");
			out.println(" </html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
