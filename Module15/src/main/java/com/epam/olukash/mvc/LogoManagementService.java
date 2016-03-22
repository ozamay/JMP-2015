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

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * @author Oleksii_Lukash
 */
@Path("/logo")
public class LogoManagementService
{
	private static final Logger logger = Logger.getLogger(LogoManagementService.class);
	private static final String UPLOAD_FILE_SERVER = "D:/demo/upload/";

	@GET
	@Path("/download/image")
	@Produces(MediaType.IMAGE_JPEG_VALUE)
	public Response downloadImageFile() {

		File file = new File("D:/demo/download/logo.jpg");

		ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"logo.jpg\"");
		return responseBuilder.build();
	}

	@POST
	@Path("/upload/images")
	@Consumes(MediaType.MULTIPART_FORM_DATA_VALUE)
	public Response uploadImageFile(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileFormDataContentDisposition) {

		String fileName = fileFormDataContentDisposition.getFileName();
		String uploadFilePath = writeToFileServer(fileInputStream, fileName);

		return Response.ok("File uploaded successfully at " + uploadFilePath).build();
	}

	private String writeToFileServer(InputStream inputStream, String fileName) {

		OutputStream outputStream = null;
		String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;
		try {
			outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
			IOUtils.copy(inputStream, outputStream);
		}
		catch (IOException ioe) {
			logger.error(ioe);
		}
		finally{
			IOUtils.closeQuietly(outputStream);
		}
		return qualifiedUploadFilePath;
	}

}
