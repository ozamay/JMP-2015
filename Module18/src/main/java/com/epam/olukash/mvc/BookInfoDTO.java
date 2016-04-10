package com.epam.olukash.mvc;

import com.epam.olukash.dto.CinemaSession;
import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii_Lukash
 */
public class BookInfoDTO
{
	private long bookingID;
	private CinemaSession cinemaSession;
	private Seat seat;

	public Seat getSeat()
	{
		return seat;
	}

	public void setSeat(Seat seat)
	{
		this.seat = seat;
	}

	public CinemaSession getCinemaSession()
	{
		return cinemaSession;
	}

	public void setCinemaSession(CinemaSession cinemaSession)
	{
		this.cinemaSession = cinemaSession;
	}

	public long getBookingID()
	{
		return bookingID;
	}

	public void setBookingID(long bookingID)
	{
		this.bookingID = bookingID;
	}


}
