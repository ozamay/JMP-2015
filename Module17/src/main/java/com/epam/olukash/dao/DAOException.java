package com.epam.olukash.dao;

/**
 * @author Oleksii.Lukash
 */
public class DAOException extends RuntimeException
{
	public static final long serialVersionUID = 1;

	public DAOException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
