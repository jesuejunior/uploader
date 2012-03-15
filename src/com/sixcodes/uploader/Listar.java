package com.sixcodes.uploader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Listar
 */
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(" <html>");
		out.println(" <center><h2> Listagem de arquivo </h2></center>");
		out.println(" <table border=1>");
		out.println(" <tr>");
		out.println(" <td>Nome</td>");
		out.println(" <td>Tamanho</td>");
		out.println(" </tr>");
		//Mostra o nome e tamanho do arquivo
		out.println(" <tr>");
		out.println(" <td></td>");
		out.println(" <td></td>");
		out.println(" </tr>");
		//finaliza a pagina
		out.println(" </table>");
		out.println(" </html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
