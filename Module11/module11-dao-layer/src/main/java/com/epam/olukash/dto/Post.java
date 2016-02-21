package com.epam.olukash.dto;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class Post extends AbstractBean
{
	private int userID;
	private String text;
	private Date CreatedDate;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Post post = (Post) o;

		if (userID != post.userID)
			return false;
		if (text != null ? !text.equals(post.text) : post.text != null)
			return false;
		return CreatedDate != null ? CreatedDate.equals(post.CreatedDate) : post.CreatedDate == null;

	}

	@Override
	public int hashCode()
	{
		int result = userID;
		result = 31 * result + (text != null ? text.hashCode() : 0);
		result = 31 * result + (CreatedDate != null ? CreatedDate.hashCode() : 0);
		return result;
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
