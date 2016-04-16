package com.epam.olukash.dto;

/**
 * @author Oleksii.Lukash
 */

public class Seat extends AbstractBean
{
	public static final long serialVersionUID = 11412132212L;

	private long seatID;
	private int seatNumber;

	public long getSeatID()
	{
		return seatID;
	}

	public void setSeatID(long seatID)
	{
		this.seatID = seatID;
	}

	public int getSeatNumber()
	{
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber)
	{
		this.seatNumber = seatNumber;
	}

}
