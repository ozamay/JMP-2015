package main.java.com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class Post
{
	private int postID;
	private int userID;
	private String text;
	private Date CreatedDate;

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

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Date getCreatedDate()
	{
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		CreatedDate = createdDate;
	}
}
