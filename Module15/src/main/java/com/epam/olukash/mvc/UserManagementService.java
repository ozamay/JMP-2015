package com.epam.olukash.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
import org.apache.commons.io.FilenameUtils;
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
	private Map<Long, User> users = new HashMap<Long, User>();
	private Map<Long, Integer> fileIdCounters = new HashMap<Long, Integer>();

	@GET
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathParam("userID") long userID)
	{
		return users.get(userID);
	}

	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(value= HttpStatus.CREATED)
	public Response createUser(User user)
	{
		user.setUserID(users.isEmpty() ? 1 : Collections.max(users.keySet()) + 1);
		users.put(user.getUserID(), user);

		logger.info(user.toString());
		logger.info("User with ID created");
		return Response.ok("Created user with ID " + user.getUserID()).build();
	}

	@PUT
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(User user, @PathParam("userID") long userID)
	{
		users.put(userID, user);

		logger.info(user.toString());
		logger.info("User with ID updated " + userID);
	}

	@DELETE
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathParam("userID") long userID)
	{
		users.remove(userID);

		logger.info("User with ID deleted: " + userID);
	}

	@GET
	@Path("/{userID}/download/{fileID}")
	@Produces(MediaType.IMAGE_JPEG_VALUE)
	public Response downloadImageFile(@PathParam("userID") long userID, @PathParam("fileID") long fileID) {

		String fileName = userID + "-" + fileID + ".jpg";
		File file = new File(FilenameUtils.concat(FileUtils.getTempDirectoryPath(), fileName));

		Response.ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"" + fileName+ "\"");
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

		int fileIdCounter = fileIdCounters.containsKey(userID) ? fileIdCounters.get(userID) : 0;
		fileIdCounter++;
		String fileName = userID + "-" + fileIdCounter + ".jpg";
		writeToFileServer(fileInputStream, fileName);
		fileIdCounters.put(userID, fileIdCounter);
		return Response.ok("File uploaded successfully with ID" + fileIdCounter).build();
	}

	private void writeToFileServer(InputStream inputStream, String fileName) {

		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File(FilenameUtils.concat(FileUtils.getTempDirectoryPath(), fileName)));
			IOUtils.copy(inputStream, outputStream);
		}
		catch (IOException ioe) {
			logger.error(ioe);
		}
		finally{
			IOUtils.closeQuietly(outputStream);
		}
	}
}
