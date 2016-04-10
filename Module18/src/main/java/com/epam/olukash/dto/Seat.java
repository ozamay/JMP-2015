package com.epam.olukash.dto;

/**
 * @author Oleksii.Lukash
 */

public class Seat extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	private long seatID;
	private int seatNumber;
	private long price;

	public long getPrice()
	{
		return price;
	}

	public void setPrice(long price)
	{
		this.price = price;
	}

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
