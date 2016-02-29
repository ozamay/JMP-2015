package com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class User extends AbstractBean
{
	private String userName;
	private String userSurName;
	private Date birthDay;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (userName != null ? !userName.equals(user.userName) : user.userName != null)
			return false;
		if (userSurName != null ? !userSurName.equals(user.userSurName) : user.userSurName != null)
			return false;
		return birthDay != null ? birthDay.equals(user.birthDay) : user.birthDay == null;

	}

	@Override
	public int hashCode()
	{
		int result = userName != null ? userName.hashCode() : 0;
		result = 31 * result + (userSurName != null ? userSurName.hashCode() : 0);
		result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
		return result;
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