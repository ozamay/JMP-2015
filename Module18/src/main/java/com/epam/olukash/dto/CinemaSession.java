package com.epam.olukash.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Oleksii.Lukash
 */
public class CinemaSession extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	private long cinemaSessionID;
	private Date sessionDate;
	private String filmName;
	private List<CinemaSessionDetail> cinemaSessionDetails;

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

	public List<CinemaSessionDetail> getCinemaSessionDetails()
	{
		return cinemaSessionDetails;
	}

	public void setCinemaSessionDetails(List<CinemaSessionDetail> cinemaSessionDetails)
	{
		this.cinemaSessionDetails = cinemaSessionDetails;
	}
}
