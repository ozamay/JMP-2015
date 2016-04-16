package com.epam.olukash.mvc;

import com.epam.olukash.dto.CinemaSession;
import com.epam.olukash.dto.Seat;
import com.epam.olukash.dto.Ticket;

/**
 * @author Oleksii_Lukash
 */
public class BookInfoDTO
{
	private CinemaSession cinemaSession;
	private Ticket ticket;
	private Seat seat;

	public Seat getSeat()
	{
		return seat;
	}

	public void setSeat(Seat seat)
	{
		this.seat = seat;
	}

	public Ticket getTicket()
	{
		return ticket;
	}

	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}

	public CinemaSession getCinemaSession()
	{
		return cinemaSession;
	}

	public void setCinemaSession(CinemaSession cinemaSession)
	{
		this.cinemaSession = cinemaSession;
	}
}
