package com.epam.olukash.dto;

/**
 * @author Oleksii.Lukash
 */
public class CinemaSessionDetail extends AbstractBean
{
	private long cinemaSessionDetailID;
	private long cinemaSessionID;
	private long seatID;
	private boolean seatBooked;

	public boolean isSeatBooked()
	{
		return seatBooked;
	}

	public void setSeatBooked(boolean seatBooked)
	{
		this.seatBooked = seatBooked;
	}

	public long getCinemaSessionDetailID()
	{
		return cinemaSessionDetailID;
	}

	public void setCinemaSessionDetailID(long cinemaSessionDetailID)
	{
		this.cinemaSessionDetailID = cinemaSessionDetailID;
	}

	public long getCinemaSessionID()
	{
		return cinemaSessionID;
	}

	public void setCinemaSessionID(long cinemaSessionID)
	{
		this.cinemaSessionID = cinemaSessionID;
	}

	public long getSeatID()
	{
		return seatID;
	}

	public void setSeatID(long seatID)
	{
		this.seatID = seatID;
	}


}
