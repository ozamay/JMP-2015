package com.epam.olukash.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Oleksii_Lukash
 */
@XmlRootElement
public class User
{
	private long userID;
	private String lastName;
	private String login;
	private String email;
	private String name;

	public User()
	{}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public long getUserID()
	{
		return userID;
	}

	public void setUserID(long userID)
	{
		this.userID = userID;
	}

	@Override
	public String toString()
	{
		return "User{" +
				"userID=" + userID +
				", lastName='" + lastName + '\'' +
				", login='" + login + '\'' +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
