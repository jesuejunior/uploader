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
	public static final String DIRETORIO_DESTINO = "/files";
	public File destinoDir;

	public Upload() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tmpDir = new File(DIRETORIO_TEMP);
		if (!tmpDir.isDirectory()) {
			throw new ServletException(DIRETORIO_TEMP + " Não é um diretorio valido");
		}
		String realPath = DIRETORIO_DESTINO;
		destinoDir = new File(realPath);
		if (!destinoDir.isDirectory()) {
			throw new ServletException(DIRETORIO_DESTINO + " não é um diretorio valido");
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.println("<h1>Uploader de arquivo</h1>");
		out.println();

		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		/*
		 * Colocar o tamanho maximo do arquivo para upload
		 */
		fileItemFactory.setSizeThreshold(200000 * 1024 * 1024); // 2 GB
		/*
		 * Diretorio temporario do upload do arquivo.
		 */
		fileItemFactory.setRepository(tmpDir);

		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		try {
			List<?> items = uploadHandler.parseRequest(request);
			Iterator<?> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();

				if (item.isFormField()) {
					out.println("Nome do arquivo = " + item.getFieldName() + ", Valor = " + item.getString());
				} else {
					// Dados do arquivo
					//String arquivo = IOUtils.toString(item.getInputStream()); //exibe conteudo do arquivo ou coloca para download
					out.println("Nome do arquivo = " + item.getName() + ", Tipo Conteudo = " + item.getContentType() + ", Tamanho do arquivo = " + item.getSize());
					File file = new File(destinoDir, item.getName());
					item.write(file);
					
					//response.sendRedirect(request.getContextPath() + "/List");
					
				}
				out.close();
			}
		} catch (FileUploadException ex) {
			log("Erro encontrado enquanto executava o request", ex);
		} catch (Exception ex) {
			log("Erro encontrado enquanto executava o upload", ex);
		}
	}

}
