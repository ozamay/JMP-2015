package main.java.com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class Like
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
}
