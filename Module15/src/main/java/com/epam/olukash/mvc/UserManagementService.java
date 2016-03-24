package com.epam.olukash.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.epam.olukash.bean.User;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * @author Oleksii_Lukash
 */
@Path("/users")
public class UserManagementService
{
	private static final Logger logger = Logger.getLogger(UserManagementService.class);

	@GET
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathParam("userID") long userID)
	{
		User user = new User();
		user.setUserID(userID);
		user.setName("Oleksii");
		user.setLastName("Lukash");
		user.setEmail("email");
		user.setLogin("login");
		return user;
	}

	@POST
	@Path("")
	@Produces(MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(value= HttpStatus.CREATED)
	public void createUser(User user)
	{
		logger.info(user.toString());
		logger.info("User with ID created");
	}

	@PUT
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(User user, @PathParam("userID") long userID)
	{
		logger.info(user.toString());
		logger.info("User with ID updated " + userID);
	}

	@DELETE
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathParam("userID") long userID)
	{
		logger.info("User with ID deleted: " + userID);
	}

	@GET
	@Path("/{userID}/download/{fileID}")
	@Produces(MediaType.IMAGE_JPEG_VALUE)
	public Response downloadImageFile(@PathParam("userID") long userID, @PathParam("fileID") long fileID) {

		FileUtils.getTempDirectoryPath();

		File file = new File(FileUtils.getTempDirectoryPath()+"/userName-" + fileID + ".jpg");

		Response.ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"logo.jpg\"");
		return responseBuilder.build();
	}

	@POST
	@Path("/{userID}/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(value= HttpStatus.CREATED)
	public Response uploadImageFile(
			@PathParam("userID") long userID,
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileFormDataContentDisposition) {

		String uploadFilePath = writeToFileServer(fileInputStream, "/userName-1.jpg");
		return Response.ok("File uploaded successfully at " + uploadFilePath).build();
	}

	private String writeToFileServer(InputStream inputStream, String fileName) {

		OutputStream outputStream = null;
		String qualifiedUploadFilePath = FileUtils.getTempDirectoryPath() + fileName;
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
