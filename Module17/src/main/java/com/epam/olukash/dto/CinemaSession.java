package com.epam.olukash.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Oleksii.Lukash
 */
@Entity
@Table (name = "CinemaSession")
public class CinemaSession extends AbstractBean
{
	@Id
	@SequenceGenerator(name = "session_seq", sequenceName = "session_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "session_seq")
	private long cinemaSessionID;

	@Column
	private Date sessionDate;

	@Column
	private String filmName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaSession")
	private List<Seat> seats;

	public long getCinemaSessionID()
	{
		return cinemaSessionID;
	}

	public void setCinemaSessionID(long cinemaSessionID)
	{
		cinemaSessionID = cinemaSessionID;
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

	public List<Seat> getSeats()
	{
		return seats;
	}

	public void setSeats(List<Seat> seats)
	{
		this.seats = seats;
	}
}
