package com.sixcodes.uploader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIRETORIO_TEMP = "/tmp/";
	private File tmpDir;
	private static final String DIRETORIO_DESTINO = "/files";
	private File destinoDir;

	public Upload() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tmpDir = new File(DIRETORIO_TEMP);
		if (!tmpDir.isDirectory()) {
			throw new ServletException(DIRETORIO_TEMP
					+ " Não é um diretorio valido");
		}
		String realPath = getServletContext().getRealPath(DIRETORIO_DESTINO);
		destinoDir = new File(realPath);
		if (!destinoDir.isDirectory()) {
			throw new ServletException(DIRETORIO_DESTINO + " não é diretorio valido");
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.println("<h1>Servlet File Upload Example using Commons File Upload</h1>");
		out.println();

		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		/*
		 * Set the size threshold, above which content will be stored on disk.
		 */
		fileItemFactory.setSizeThreshold(1000 * 1024 * 1024); // 1 GB
		/*
		 * Set the temporary directory to store the uploaded files of size above
		 * threshold.
		 */
		fileItemFactory.setRepository(tmpDir);

		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		try {
			/*
			 * Parse the request
			 */
			List<?> items = uploadHandler.parseRequest(request);
			Iterator<?> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				/*
				 * Handle Form Fields.
				 */
				if (item.isFormField()) {
					out.println("Nome do arquivo = " + item.getFieldName()
							+ ", Value = " + item.getString());
				} else {
					// Handle Uploaded files.
					out.println("Field Name = " + item.getFieldName()
							+ ", File Name = " + item.getName()
							+ ", Content type = " + item.getContentType()
							+ ", File Size = " + item.getSize());
					/*
					 * Write file to the ultimate location.
					 */
					File file = new File(destinoDir, item.getName());
					item.write(file);
				}
				out.close();
			}
		} catch (FileUploadException ex) {
			log("Error encountered while parsing the request", ex);
		} catch (Exception ex) {
			log("Error encountered while uploading file", ex);
		}
	}

}
