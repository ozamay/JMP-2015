package com.epam.olukash.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Oleksii.Lukash
 */
public class CinemaSession extends AbstractBean
{
	public static final long serialVersionUID = 11234121312L;

	private long cinemaSessionID;
	private Date sessionDate;
	private String filmName;
	private List<Ticket> tickets;

	public long getCinemaSessionID()
	{
		return cinemaSessionID;
	}

	public void setCinemaSessionID(long cinemaSessionID)
	{
		this.cinemaSessionID = cinemaSessionID;
	}

	public Date getSessionDate()
	{
		return sessionDate;
	}

	public void setSessionDate(Date sessionDate)
	{
		this.sessionDate = sessionDate;
	}

	public String getFilmName()
	{
		return filmName;
	}

	public void setFilmName(String filmName)
	{
		this.filmName = filmName;
	}

	public List<Ticket> getTickets()
	{
		return tickets;
	}

	public void setTickets(List<Ticket> tickets)
	{
		this.tickets = tickets;
	}
}
