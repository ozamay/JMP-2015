package main.java.com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class FriendShip
{
	private int userID1;
	private int userID2;
	private Date createdDate;

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
