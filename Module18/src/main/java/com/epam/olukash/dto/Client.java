package com.epam.olukash.dto;

import javax.validation.constraints.Size;

/**
 * @author Oleksii.Lukash
 */
public class Client extends AbstractBean
{
	public static final long serialVersionUID = 1L;
	private long clientID;

	@Size(min=1, max=100, message="Name is require")
	private String name;

	@Size(min=1, max=100, message="SurName is require")
	private String surName;

	public String getSurName()
	{
		return surName;
	}

	public void setSurName(String surName)
	{
		this.surName = surName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getClientID()
	{
		return clientID;
	}

	public void setClientID(long clientID)
	{
		this.clientID = clientID;
	}
}
