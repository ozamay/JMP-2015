package com.epam.olukash.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Oleksii.Lukash
 */

@Entity
@Table(name = "Seat")
public class Seat extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seatID;

	@Column
	private int seatNumber;

	@Column
	private boolean booked;

	@Column
	private long price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cinemaSessionID")
	private CinemaSession cinemaSession;

	public CinemaSession getCinemaSession()
	{
		return cinemaSession;
	}

	public void setCinemaSession(CinemaSession cinemaSession)
	{
		this.cinemaSession = cinemaSession;
	}

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

	public boolean isBooked()
	{
		return booked;
	}

	public void setBooked(boolean booked)
	{
		this.booked = booked;
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
