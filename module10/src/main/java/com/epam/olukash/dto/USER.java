package main.java.com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class User
{
	private int userID;
	private String userName;
	private String userSurName;
	private Date birthDay;

	public int getUserID()
	{
		return userID;
	}

	public void setUserID(int userID)
	{
		this.userID = userID;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserSurName()
	{
		return userSurName;
	}

	public void setUserSurName(String userSurName)
	{
		this.userSurName = userSurName;
	}

	public Date getBirthDay()
	{
		return birthDay;
	}

	public void setBirthDay(Date birthDay)
	{
		this.birthDay = birthDay;
	}


}
