package com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class Like extends AbstractBean
{
	private int postID;
	private int userID;
	private Date createDate;

	public int getPostID()
	{
		return postID;
	}

	public void setPostID(int postID)
	{
		this.postID = postID;
	}

	public int getUserID()
	{
		return userID;
	}

	public void setUserID(int userID)
	{
		this.userID = userID;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Like like = (Like) o;

		if (postID != like.postID)
			return false;
		if (userID != like.userID)
			return false;
		return createDate != null ? createDate.equals(like.createDate) : like.createDate == null;

	}

	@Override
	public int hashCode()
	{
		int result = postID;
		result = 31 * result + userID;
		result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
		return result;
	}
}
