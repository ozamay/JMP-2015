package com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class FriendShip extends AbstractBean
{
	private int userID1;
	private int userID2;
	private Date createdDate;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FriendShip that = (FriendShip) o;

		if (userID1 != that.userID1)
			return false;
		if (userID2 != that.userID2)
			return false;
		return createdDate != null ? createdDate.equals(that.createdDate) : that.createdDate == null;

	}

	@Override
	public int hashCode()
	{
		int result = userID1;
		result = 31 * result + userID2;
		result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
		return result;
	}

	public int getUserID1()
	{
		return userID1;
	}

	public void setUserID1(int userID1)
	{
		this.userID1 = userID1;
	}

	public int getUserID2()
	{
		return userID2;
	}

	public void setUserID2(int userID2)
	{
		this.userID2 = userID2;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
}
