package com.epam.olukash.mvc;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.epam.olukash.bean.User;

/**
 * @author Oleksii_Lukash
 */
@Path("/users")
public class UserManagmentService
{
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
	  System.out.println(user.toString());
	  System.out.println("User with ID created");
	}

	@PUT
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public void updateActor(User user, @PathParam("userID") long userID)
	{
		System.out.println(user.toString());
		System.out.println("User with ID updated " + userID);
	}

	@DELETE
	@Path("/{userID}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public void deleteActor(@PathParam("userID") long userID)
	{
		System.out.println("User with ID deleted: " + userID);
	}
}
