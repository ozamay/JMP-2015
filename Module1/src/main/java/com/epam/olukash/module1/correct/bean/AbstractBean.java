package com.epam.olukash.module1.correct.bean;

import java.util.Date;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public abstract class AbstractBean
{
	private long ID;
	private Date createdDate;

	//////////////////////////////////////////////////////

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public long getID()
	{
		return ID;
	}

	public void setID(long ID)
	{
		this.ID = ID;
	}
}
