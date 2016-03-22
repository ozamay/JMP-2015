package com.epam.olukash.mvc;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.epam.olukash.bean.User;

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
}
