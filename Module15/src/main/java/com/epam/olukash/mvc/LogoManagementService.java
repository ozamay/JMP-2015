package com.epam.olukash.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.http.MediaType;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * @author Oleksii_Lukash
 */
@Path("/logo")
public class LogoManagementService
{
	public static final String UPLOAD_FILE_SERVER = "D:/demo/upload/";

	@GET
	@Path("/download/image")
	@Produces(MediaType.IMAGE_JPEG_VALUE)
	public Response downloadImageFile() {

		File file = new File("D:/demo/download/logo.jpg");

		ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"logo.jpg\"");
		return responseBuilder.build();
	}

	private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {

		OutputStream outputStream = null;
		String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;

		try {
			outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
			int read;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally{
			outputStream.close();
		}
		return qualifiedUploadFilePath;
	}


	@POST
	@Path("/upload/images")
	@Consumes(MediaType.MULTIPART_FORM_DATA_VALUE)
	public Response uploadImageFile(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileFormDataContentDisposition) {

		String fileName;
		String uploadFilePath = null;

		try {
			fileName = fileFormDataContentDisposition.getFileName();
			uploadFilePath = writeToFileServer(fileInputStream, fileName);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return Response.ok("File uploaded successfully at " + uploadFilePath).build();
	}

}
