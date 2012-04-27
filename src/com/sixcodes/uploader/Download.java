package com.sixcodes.uploader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixcodes.dao.HibernateUtil;

/**
 * Servlet implementation class Download
 */
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Arquivo arquivo = new Arquivo();
	
	public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		Arquivo arquivo = new Arquivo();
		PrintWriter out = response.getWriter();
		//response.setContentType("application/octet-stream");
		response.setContentType("text/plain");
		
		String a = request.getParameter("id");
		
		out.println(a);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
